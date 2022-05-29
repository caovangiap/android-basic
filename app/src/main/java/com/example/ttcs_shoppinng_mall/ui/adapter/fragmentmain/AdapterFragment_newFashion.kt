package com.example.ttcs_shoppinng_mall.ui.adapter.fragmentmain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.ttcs_shoppinng_mall.Detail_data
import com.example.ttcs_shoppinng_mall.R
import com.example.ttcs_shoppinng_mall.data.model.NewFashion


class AdapterFragment_newFashion(val data: MutableList<NewFashion>) :
    RecyclerView.Adapter<AdapterFragment_newFashion.viewholder>() {

    class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView
        val textView: TextView

        init {
            imageView = itemView.findViewById(R.id.image_thisweekhighlights)
            textView = itemView.findViewById(R.id.text_thisweekhighlights)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.detail_fragment_newfashion, parent, false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {

        holder.imageView.setImageURI(data[position].Image?.toUri())
        holder.textView.setText(data[position].Titel)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}