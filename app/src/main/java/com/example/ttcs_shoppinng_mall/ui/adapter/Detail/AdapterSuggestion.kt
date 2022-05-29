package com.example.ttcs_shoppinng_mall.ui.adapter.Detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ttcs_shoppinng_mall.R
import com.example.ttcs_shoppinng_mall.data.model.Suggestion


class AdapterSuggestion(val data:ArrayList<Suggestion>) : RecyclerView.Adapter<AdapterSuggestion.ViewHolder>() {

     class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image : ImageView
        val name : TextView
        val type : TextView
        val price : TextView
        init {
            image= itemView.findViewById(R.id.image_suggestion)
            name = itemView.findViewById(R.id.name)
            type = itemView.findViewById(R.id.type)
            price = itemView.findViewById(R.id.price)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_suggest,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(data[position].product_image)
        holder.name.text = data[position].product_name
        holder.price.text = data[position].product_price.toString()
        holder.type.text = data[position].product_type
    }

    override fun getItemCount(): Int {
       return data.size
    }


}