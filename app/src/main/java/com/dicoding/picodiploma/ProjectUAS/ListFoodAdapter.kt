package com.dicoding.picodiploma.ProjectUAS

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListFoodAdapter(val listFood: ArrayList<food>) : RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_food, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val food = listFood[position]

        Glide.with(holder.itemView.context)
            .load(food.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = food.name
        holder.tvDetail.text = food.detail

        //holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listFood[holder.adapterPosition]) }

        holder.itemView.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                onItemClickCallback.onItemClicked(listFood[holder.adapterPosition])
                val detailhalaman = Intent(view.context.applicationContext, DetailActivity::class.java)

                detailhalaman.putExtra(DetailActivity.NAMA, food.name)
                detailhalaman.putExtra(DetailActivity.DETAIL, food.detail)
                detailhalaman.putExtra(DetailActivity.PRICE, food.price)
                detailhalaman.putExtra(DetailActivity.PHOTO, food.photo)
                view.context.startActivity(detailhalaman)
            }
        })
    }

    override fun getItemCount(): Int {
        return listFood.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: food)
    }
}