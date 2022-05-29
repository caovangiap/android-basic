package com.example.ttcs_shoppinng_mall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.ttcs_shoppinng_mall.ui.adapter.Detail.AdapterDetail
import me.relex.circleindicator.CircleIndicator3

class FragmentDetail2 :Fragment() {

    lateinit var view_item: ViewPager2
    lateinit var CircleIndicator : CircleIndicator3
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragmentdetail2,container,false)
        view_item = view.findViewById(R.id.view_item)
        CircleIndicator = view.findViewById(R.id.CircleIndicator)
        adapter_view()
        return view
    }

    private fun adapter_view() {
        val adapter = AdapterDetail(data_detail())
        data_detail()
        view_item.adapter = adapter
        CircleIndicator.setViewPager(view_item)
    }

    fun data_detail(): MutableList<Detail_data>{
        val data = mutableListOf<Detail_data>()
        for (i in 1..4){
            data.add(Detail_data(R.drawable.img_4))
            data.add(Detail_data(R.drawable.img_5))
            data.add(Detail_data(R.drawable.img_6))
            data.add(Detail_data(R.drawable.img_7))
        }
        return data
    }


}