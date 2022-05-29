package com.example.ttcs_shoppinng_mall.ui.fragment.allitems_men

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import com.example.ttcs_shoppinng_mall.R
import com.example.ttcs_shoppinng_mall.databinding.FragmentAllproductBinding
import com.example.ttcs_shoppinng_mall.ui.activity.ActivityMain
import com.google.android.material.tabs.TabLayout

class FragemntAllProduct : Fragment() {
    lateinit var binding: FragmentAllproductBinding
    lateinit var tabLayout: TabLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAllproductBinding.inflate(inflater, container, false)
        super.onCreateView(inflater, container, savedInstanceState)
        tabLayout = binding.TabLayout
        binding.myToolbar.inflateMenu(R.menu.toolbar)
        binding.myToolbar.setNavigationIcon(R.drawable.ic_back)
//yêu cầu activity điều hướng quay trở lại
        binding.myToolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
// set các sự kiện click cho toolbal
        binding.myToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search -> {
                    val intent = Intent(context, ActivityMain::class.java)
                    startActivity(intent)
                    true
                }
                R.id.bag -> {
                    // Save profile changes
                    true
                }
                else -> false
            }
        }
// tablayout điều hướng hiển thị các sản phẩm
        tablayout()
        return binding.root
    }


    fun tablayout() {
        val fragment_shoe = shoe()
        val fragmentTransition = childFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.view, fragment_shoe)
        fragmentTransition.commit()
        val fragment_clothing = Clothing()
        val fragment_accessory = Accessory()
        tabLayout.addTab(tabLayout.newTab().setText("Shoe"), true)
        tabLayout.addTab(tabLayout.newTab().setText("Clothing"))
        tabLayout.addTab(tabLayout.newTab().setText("Accessory"))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val position = tab?.position
                when (position) {
                    0 -> {

                        val fragmentTransition = childFragmentManager.beginTransaction()
                        fragmentTransition.replace(R.id.view, fragment_shoe)
                        fragmentTransition.commit()
                    }
                    1 -> {

                        val fragmentTransition = childFragmentManager.beginTransaction()
                        fragmentTransition.replace(R.id.view, fragment_clothing)
                        fragmentTransition.commit()
                    }
                    2 -> {

                        val fragmentTransition = childFragmentManager.beginTransaction()
                        fragmentTransition.replace(R.id.view, fragment_accessory)
                        fragmentTransition.commit()
                    }
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("FragmentAllProduct", "FragmentAllProduct: onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onPause() {
        Log.d("FragmentAllProduct", "FragmentAllProduct: onPause")
        super.onPause()
    }

    override fun onAttach(context: Context) {
        Log.d("FragmentAllProduct", "FragmentAllProduct: onAttach")
        super.onAttach(context)
    }

    override fun onStop() {
        Log.d("FragmentAllProduct", "FragmentAllProduct: onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("FragmentAllProduct", "FragmentAllProduct: onDestroy")
        super.onDestroy()
    }

}