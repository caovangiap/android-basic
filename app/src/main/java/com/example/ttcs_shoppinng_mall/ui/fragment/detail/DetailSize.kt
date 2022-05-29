package com.example.ttcs_shoppinng_mall.ui.fragment.detail

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ttcs_shoppinng_mall.data.model.Product
import com.example.ttcs_shoppinng_mall.databinding.ActivitydetailsizeBinding
import com.example.ttcs_shoppinng_mall.R

import com.example.ttcs_shoppinng_mall.ui.adapter.Detail.AdapterDetailSize

class DetailSize :Fragment() {
    lateinit var binding: ActivitydetailsizeBinding
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
        binding = ActivitydetailsizeBinding.inflate(layoutInflater)
        binding.toolbar.inflateMenu(R.menu.toolbar_selectsize)
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.cancel -> {
                    activity?.onBackPressed()
                    true
                }
                else -> false
            }
        }
        val view = binding.root
        adaptersize()

        return view
    }
    private fun adaptersize() {
        val data = ArrayList<Product>()
        for (i in 1..10) {
            data.add(
                Product(
                    "ID",
                    "airforce",
                    "120",
                    "20",
                    true,
                    "us",
                    R.color.cardview_shadow_end_color,
                    R.drawable.backgroud_button
                )
            )
        }
        val adapter = AdapterDetailSize(data)
        binding.DetailSize.adapter = adapter
        binding.DetailSize.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)

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

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    override fun onDetach() {
        super.onDetach()

    }


}