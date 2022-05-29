package com.example.ttcs_shoppinng_mall.ui.adapter.FragmentAllitems_men


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.ttcs_shoppinng_mall.Detail_data
import com.example.ttcs_shoppinng_mall.R
import com.example.ttcs_shoppinng_mall.data.model.Product
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

open class AdapterShoe(val data : MutableList<Product>) :
    RecyclerView.Adapter<AdapterShoe.ViewHodler>() {
    lateinit var onclick :Setonclick
    lateinit var context_1: Context
    val data_items = mutableListOf<Detail_data>()


    interface Setonclick{
        fun onclick(position: Int){
        }
    }
    fun listener (listener: Setonclick){
        onclick = listener
    }

     class ViewHodler(items: View, click : Setonclick) : RecyclerView.ViewHolder(items)
    {
        val recycler: ViewPager2
        val name: TextView
        val type: TextView
        val price: TextView
        val indicator : DotsIndicator


        init {
            recycler = items.findViewById(R.id.recycler)
            name = items.findViewById(R.id.name)
            type = items.findViewById(R.id.type)
            price = items.findViewById(R.id.price)
            indicator = items.findViewById(R.id.CircleIndicator)

            items.setOnClickListener{
               click.onclick(adapterPosition)
            }
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodler {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_shoe, parent, false)
        context_1 = parent.context

        return ViewHodler(view,onclick)
    }

    override fun onBindViewHolder(holder: ViewHodler, position: Int) {

        data_items.add(Detail_data(R.drawable.img))
        data_items.add(Detail_data(R.drawable.img_2))
        data_items.add(Detail_data(R.drawable.img_3))
        data_items.add(Detail_data(R.drawable.img_1))
        holder.recycler.adapter = items_shoe(data_items)
        holder.indicator.setViewPager2(holder.recycler)
        holder.price.setText(data[position].product_price)
        holder.name.setText(data[position].product_name)
        holder.type.setText(data[position].product_type)
    }
    override fun getItemCount(): Int {
        return data.size
    }

}


//các items shoe
open class items_shoe(val data: MutableList<Detail_data>) :
    RecyclerView.Adapter<items_shoe.ViewHolder>() {

    class ViewHolder(items: View) : RecyclerView.ViewHolder(items) {
        val Image_detail: ImageView

        init {
            Image_detail = items.findViewById(R.id.Image_detail)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.imagedetail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Image_detail.setImageResource(data[position].image)
    }

    override fun getItemCount(): Int {
        return 4
    }
}

