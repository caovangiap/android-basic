package com.example.ttcs_shoppinng_mall.ui.adapter.Detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ttcs_shoppinng_mall.R
import com.example.ttcs_shoppinng_mall.data.model.Product


class AdapterDetailSize(val data: ArrayList<Product>) : RecyclerView.Adapter<AdapterDetailSize.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Textsize : TextView

        init {
            Textsize = itemView.findViewById(R.id.size)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.detailsize,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.Textsize.text = data[position].product_size
    }

    override fun getItemCount(): Int {
       return data.size
    }
}