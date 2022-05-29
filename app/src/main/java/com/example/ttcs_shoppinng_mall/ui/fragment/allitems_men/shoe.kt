package com.example.ttcs_shoppinng_mall.ui.fragment.allitems_men


import android.content.Context

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ttcs_shoppinng_mall.R
import com.example.ttcs_shoppinng_mall.data.model.Product
import com.example.ttcs_shoppinng_mall.databinding.FragmentAllproductShoeBinding
import com.example.ttcs_shoppinng_mall.ui.activity.ActivityMain


import com.example.ttcs_shoppinng_mall.ui.adapter.FragmentAllitems_men.AdapterShoe




class shoe : Fragment() {

    var binding: FragmentAllproductShoeBinding? = null
    lateinit var layout : View
    // dữ liệu adapter list sản phẩm
    val data_SetItems = mutableListOf<Product>()
    // dữ liệu items gửi đi activity Detail
    lateinit var data_Items :DataItemsShoe

    interface DataItemsShoe{
        fun SetData_shoe(data: Product)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data_Items = activity as ActivityMain
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllproductShoeBinding.inflate(inflater,container,false)
        layout = binding?.root!!
        FillData()
        return layout
    }

    fun FillData(){
        SetUpData()
        val adapterShoe = AdapterShoe(data_SetItems)
        adapterShoe.listener(object: AdapterShoe.Setonclick{
            override fun onclick(position: Int) {
                // mở ra màn mới và truyền dữ liệu từng items đến activity detail
                data_Items.SetData_shoe(data_SetItems[position])

            }
        })
        binding?.viewItem?.adapter = adapterShoe
        binding?.viewItem?.layoutManager = StaggeredGridLayoutManager(2,GridLayoutManager.VERTICAL)
    }
     fun  SetUpData(){
         data_SetItems.add(
             Product("ID",
                 "airforce",
                 "120",
                 "20",
                 true,
                 "us",
                 R.color.cardview_shadow_end_color,
                 R.drawable.img_3)
         )
         data_SetItems.add(
             Product("ID",
                 "airforce",
                 "120",
                 "20",
                 true,
                 "us",
                 R.color.cardview_shadow_end_color,
                 R.drawable.img)
         )
         data_SetItems.add(
             Product("ID",
                 "airforce",
                 "120",
                 "20",
                 true,
                 "us",
                 R.color.cardview_shadow_end_color,
                 R.drawable.img_2)
         )
         data_SetItems.add(
             Product("ID",
                 "airforce",
                 "120",
                 "20",
                 true,
                 "us",
                 R.color.cardview_shadow_end_color,
                 R.drawable.img_1)
         )

    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
    override fun onStart() {
        Log.d("FragmentAllProduct", "shoe: onStart")
        super.onStart()
    }
    override fun onResume() {
        Log.d("FragmentAllProduct", "shoe: onResume")
        super.onResume()
    }
    override fun onPause() {
        Log.d("FragmentAllProduct", "shoe: onPause")
        super.onPause()
    }
    override fun onStop() {
        Log.d("FragmentAllProduct", "shoe: onStop")
        super.onStop()
    }
    override fun onDestroy() {
        Log.d("FragmentAllProduct", "shoe: onDestroy")
        super.onDestroy()
        binding= null
    }
}