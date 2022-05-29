package com.example.ttcs_shoppinng_mall.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ttcs_shoppinng_mall.FragmentDetail1
import com.example.ttcs_shoppinng_mall.FragmentDetail2
import com.example.ttcs_shoppinng_mall.R
import com.example.ttcs_shoppinng_mall.data.model.Product
import com.example.ttcs_shoppinng_mall.data.model.Suggestion
import com.example.ttcs_shoppinng_mall.databinding.ActivitydetailBinding
import com.example.ttcs_shoppinng_mall.ui.adapter.Detail.AdapterSuggestion
import com.example.ttcs_shoppinng_mall.ui.fragment.detail.DetailSize

class Detail : AppCompatActivity() {

    lateinit var binding: ActivitydetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitydetailBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        //   setclickview()

        when (intent.getStringExtra("data_items")) {
            "shoe" -> {
                SetData_shoe()
                setclickview()
            }
            "Accessory" -> {
                SetData_shoe()
                setclickview()
            }
            "Clothing" -> {
                SetData_shoe()
                setclickview()
            }

        }

        adapterSuggestion()

        binding.SelectSize.setOnClickListener {
            setsize()
        }
    }

    // dữ liệu items lấy từ shoe setup lên detail
    fun SetData_shoe() {
        val data = intent.getParcelableExtra<Product>("Data_Items_Shoe")
        val fragmentDetail1 = FragmentDetail1()
        val fragmentDetail2 = FragmentDetail2()
        val bundle = Bundle()
        bundle.putParcelable("data_items_shoe", data)
        fragmentDetail1.arguments = bundle
        fragmentDetail2.arguments = bundle
    }

    // set size cho sản phẩm
    private fun setsize() {
        val fragment = DetailSize()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.parent, fragment)
        fragmentTransition.addToBackStack(null)
        fragmentTransition.commit()
    }

    // set ảnh view sản phẩm đầu trang
    private fun setclickview() {

        val detailview1 = FragmentDetail1()
        replacefragment(detailview1)
        binding.ImageView1.setOnClickListener() {
            replacefragment(detailview1)
        }
        binding.ImageView2.setOnClickListener() {
            val detailview2 = FragmentDetail2()
            replacefragment(detailview2)
        }
    }

    private fun replacefragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.view_fragment, fragment)
        fragmentTransition.commit()
    }

    // adapter cho các sản phẩm gợi ý
    fun adapterSuggestion() {
        val data = ArrayList<Suggestion>()
        for (i in 1..10) {
            data.add(
                Suggestion(
                    "ID",
                    "airforce",
                    "120",
                    "20",
                    true,
                    "us",
                    R.color.cardview_shadow_end_color,
                    R.drawable.img_2
                )
            )
        }
        binding.suggestion.adapter = AdapterSuggestion(data)
        binding.suggestion.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
    }
}

