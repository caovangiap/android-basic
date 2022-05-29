package com.example.ttcs_shoppinng_mall.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.ttcs_shoppinng_mall.R
import com.example.ttcs_shoppinng_mall.data.model.Product
import com.example.ttcs_shoppinng_mall.databinding.ActivitymainBinding
import com.example.ttcs_shoppinng_mall.ui.adapter.fragmentmain.AdapterViewPagerMain
import com.example.ttcs_shoppinng_mall.ui.fragment.allitems_men.FragemntAllProduct
import com.example.ttcs_shoppinng_mall.ui.fragment.allitems_men.shoe
import com.google.android.material.tabs.TabLayoutMediator


open class ActivityMain : AppCompatActivity(),shoe.DataItemsShoe {

    lateinit var binnding: ActivitymainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binnding = ActivitymainBinding.inflate(layoutInflater)
        val view = binnding.root
        setContentView(view)
        //
        binnding.viewpager2.adapter = AdapterViewPagerMain(this)
        tablayout()
        binnding.myToolbar.inflateMenu(R.menu.toolbar)
        binnding.myToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search -> {
                    val intent = Intent(this, Detail::class.java)
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
    }
    override fun onResume() {
        super.onResume()
    }
    //chuyen tab fragment
    fun tablayout() {
        TabLayoutMediator(binnding.TabLayout, binnding.viewpager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Men"
                }
                1 -> {
                    tab.text = "Women"
                }
                2 -> {
                    tab.text = "Kid"
                }
            }
        }.attach()
    }

// mở ra danh sách các sản phẩm
    open fun change() {
        val child = FragemntAllProduct()
        val main = supportFragmentManager.beginTransaction()
            main.addToBackStack("FragmentAllProduct")
            .setCustomAnimations(
               R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
            )
            .addToBackStack(null)
            .replace(R.id.frane_container, child)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

    }

    // nhận data các itesm trong shoe fragment chuyển sang activity Detail
    override fun SetData_shoe(data: Product) {
       val intent = Intent(this,Detail::class.java)
        intent.putExtra("Data_Items_Shoe",data)
        intent.putExtra("data_items","shoe")
        startActivity(intent)
    }
}





