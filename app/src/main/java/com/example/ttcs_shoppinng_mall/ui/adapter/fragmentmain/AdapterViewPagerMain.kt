package com.example.ttcs_shoppinng_mall.ui.adapter.fragmentmain

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ttcs_shoppinng_mall.ui.fragment.main.FragmentKid
import com.example.ttcs_shoppinng_mall.ui.fragment.main.FragmentMen
import com.example.ttcs_shoppinng_mall.ui.fragment.main.FragmentWomen



class AdapterViewPagerMain(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
      return  when(position){
          0-> FragmentMen()
          1-> FragmentWomen()
          2-> FragmentKid()
          else -> {
              FragmentMen()
          }
      }
    }
}