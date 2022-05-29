package com.example.ttcs_shoppinng_mall.ui.fragment.main

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ttcs_shoppinng_mall.Detail_data
import com.example.ttcs_shoppinng_mall.R
import com.example.ttcs_shoppinng_mall.databinding.FragmentmainKidBinding
import com.example.ttcs_shoppinng_mall.ui.adapter.fragmentmain.AdapterFragment_newFashion
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Comment

class FragmentKid : Fragment() {

    lateinit var binding: FragmentmainKidBinding
    private lateinit var database_NewFashion: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentmainKidBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }

    fun init(){
        database_NewFashion = Firebase.database.reference
        database_NewFashion.child("New_Fashion").child("New1")
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onStart() {
        super.onStart()
        init()

    }
}