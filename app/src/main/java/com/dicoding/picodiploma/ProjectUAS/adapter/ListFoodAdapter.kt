package com.dicoding.picodiploma.ProjectUAS.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.ProjectUAS.R
import com.dicoding.picodiploma.ProjectUAS.data.food
import kotlinx.android.synthetic.main.item_row_food.view.*

class ListFoodAdapter: RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>() {
    private val mData = ArrayList<food>()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setData(items: ArrayList<food>){
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_food, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int = mData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(food: food) {
            with(itemView) {
                //set foto
                Glide.with(itemView.context)
                    .load(food.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)

                //set nama dan detail
                tv_item_name.text = food.name
                tv_item_detail.text = food.detail
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(food) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: food)
    }
}