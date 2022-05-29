package com.example.ttcs_shoppinng_mall.ui.adapter.Detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ttcs_shoppinng_mall.Detail_data
import com.example.ttcs_shoppinng_mall.R


class AdapterDetail( val dataSet:MutableList<Detail_data>) : RecyclerView.Adapter<AdapterDetail.Detail_viewhodel>() {

    class Detail_viewhodel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image_view: ImageView
        init {
            image_view = itemView.findViewById(R.id.Image_detail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Detail_viewhodel {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.imagedetail,parent, false)
        return Detail_viewhodel(view)
    }

    override fun onBindViewHolder(holder: Detail_viewhodel, position: Int) {
        holder.image_view.setImageResource(dataSet[position].image)
    }
    override fun getItemCount(): Int {
        return dataSet.size
    }


}