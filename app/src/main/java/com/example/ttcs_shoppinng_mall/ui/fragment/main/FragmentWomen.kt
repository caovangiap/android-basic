package com.example.ttcs_shoppinng_mall.ui.fragment.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ttcs_shoppinng_mall.Detail_data
import com.example.ttcs_shoppinng_mall.R
import com.example.ttcs_shoppinng_mall.databinding.FragmentmainWomenBinding
import com.example.ttcs_shoppinng_mall.ui.adapter.fragmentmain.AdapterFragment_newFashion

class FragmentWomen : Fragment() {

    lateinit var binding: FragmentmainWomenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentmainWomenBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }


}