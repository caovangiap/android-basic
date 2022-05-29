package com.example.ttcs_shoppinng_mall.ui.adapter.fragmentmain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ttcs_shoppinng_mall.R
import com.example.ttcs_shoppinng_mall.data.model.Product


class AdapterFragment_recommendProduct(val data : MutableList<Product>) :RecyclerView.Adapter<AdapterFragment_recommendProduct.ViewHolder>() {
    class ViewHolder (val item :View) : RecyclerView.ViewHolder(item){
        val imagesuggest : ImageView
        val text_name : TextView
        val text_type :TextView
        val text_price :TextView
        init {
            imagesuggest = item.findViewById(R.id.image_suggestion)
            text_name = item.findViewById(R.id.name)
            text_type = item.findViewById(R.id.type)
            text_price = item.findViewById(R.id.price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_suggest,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imagesuggest.setImageResource(data[position].product_image)
        holder.text_name.setText(data[position].product_name)
        holder.text_type.setText(data[position].product_type)
        holder.text_price.setText(data[position].product_price)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}