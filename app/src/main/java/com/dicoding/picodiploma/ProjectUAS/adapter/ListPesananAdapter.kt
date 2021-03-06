package com.dicoding.picodiploma.ProjectUAS.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.ProjectUAS.R
import com.dicoding.picodiploma.ProjectUAS.data.food

class ListPesananAdapter internal constructor(context: Context) : RecyclerView.Adapter<ListPesananAdapter.FoodViewHolder>() {

    //deklarasi inflater, listener, object
    private val inflater: LayoutInflater= LayoutInflater.from(context)
    private var foods = emptyList<food>()
    var clickListener : OnClickListener? = null


    // deklarasi id
    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val foodFoodID: TextView = itemView.findViewById(R.id.tv_foodID)
        val foodPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val foodName: TextView = itemView.findViewById(R.id.tv_item_name)
        val foodQuantity: TextView = itemView.findViewById(R.id.tv_quantity)
        val foodPrice: TextView = itemView.findViewById(R.id.tv_price)
    }

    //select item_row_pesanan.xml sebagai item_row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = inflater.inflate(R.layout.item_row_pesanan,parent, false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int){
        //nampilkan di list
        val current = foods[position]

        //set foto
        Glide.with(holder.itemView.context)
            .load(current.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.foodPhoto)

        // set detail
        holder.foodFoodID.text = current.foodId.toString()
        holder.foodName.text = current.name
        holder.foodQuantity.text = current.quantity.toString()
        holder.foodPrice.text = current.price.toString()
        holder.foodName.setOnClickListener({itemView -> clickListener?.onClick(position)})
    }

    //setData pada recyclerView
    internal fun setFoods(foods: List<food>) {
        this.foods = foods
        notifyDataSetChanged()
    }
    override fun getItemCount() = foods.size

    interface OnClickListener{
        fun onClick(position: Int)
    }
}