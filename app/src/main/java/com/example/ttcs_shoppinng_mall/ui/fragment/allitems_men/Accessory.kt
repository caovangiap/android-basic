package com.example.ttcs_shoppinng_mall.ui.fragment.allitems_men

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ttcs_shoppinng_mall.data.model.Product
import com.example.ttcs_shoppinng_mall.databinding.FragmentAllproductAccessoryBinding
import com.example.ttcs_shoppinng_mall.ui.activity.Detail
import com.example.ttcs_shoppinng_mall.R

import com.example.ttcs_shoppinng_mall.ui.adapter.FragmentAllitems_men.AdapterShoe

class Accessory: Fragment() {

    lateinit var binding: FragmentAllproductAccessoryBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllproductAccessoryBinding.inflate(inflater,container,false)
        val view = binding.root
        FillData()
        return view
    }
    fun FillData(){
        val data_3 = mutableListOf<Product>()
        for (i in 1..8){
            data_3.add(
                Product("ID",
                    "airforce",
                    "120",
                    "20",
                    true,
                    "us",
                    R.color.cardview_shadow_end_color,
                    R.drawable.img_2)
            )
        }
        val adapterShoe = AdapterShoe(data_3)
        adapterShoe.listener(object: AdapterShoe.Setonclick{
            override fun onclick(position:Int) {

                val intent = Intent(context, Detail::class.java)
                startActivity(intent)
            }
        })
        binding.viewItem.adapter = adapterShoe
        binding.viewItem.layoutManager = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)


    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}