package com.example.ttcs_shoppinng_mall.ui.fragment.main

import android.content.ContentValues
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
import com.example.ttcs_shoppinng_mall.R
import com.example.ttcs_shoppinng_mall.data.model.NewFashion
import com.example.ttcs_shoppinng_mall.data.model.Product
import com.example.ttcs_shoppinng_mall.ui.activity.ActivityMain
import com.example.ttcs_shoppinng_mall.databinding.FragmentmainMenBinding
import com.example.ttcs_shoppinng_mall.ui.adapter.fragmentmain.AdapterFragment_newFashion
import com.example.ttcs_shoppinng_mall.ui.adapter.fragmentmain.AdapterFragment_recommendProduct
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Comment

class FragmentMen : Fragment() {

    lateinit var binding: FragmentmainMenBinding
    private lateinit var database_NewFashion: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentmainMenBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        return view
    }

    private fun init() {
        database_NewFashion = Firebase.database.reference
        database_NewFashion.child("New_Fashion")
    }

    fun SetOnClick() {
        // hiển thị các sản phẩm
        binding.newfeatured.setOnClickListener {
            allProduct()
        }
    }

    private fun recycler_RecommendProduct() {
        val data = mutableListOf<Product>()
        for (i in 1..4) {
            data.add(
                Product(
                    "1",
                    "ariforce",
                    "100$",
                    "39us",
                    true,
                    "men",
                    2,
                    R.drawable.img_1
                )
            )
        }
        binding.recommendProduct.adapter = AdapterFragment_recommendProduct(data)
        binding.recommendProduct.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
    }

    // adapter phần tin tức thời trang ( this wwek's hightlight)
    fun recycler_NewFashion() {

//        val childEventListener = object : ChildEventListener {
//
//            // lấy data về
//            override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
//                Log.d(TAG, "onChildAdded:" + dataSnapshot.key!!)
//                val data_new = dataSnapshot.getValue<NewFashion>()
//                val DataNewFashion = mutableListOf<NewFashion>()
//                if (data_new!=null){
//                    DataNewFashion.add(data_new)
//                    binding.newFashion.adapter = AdapterFragment_newFashion(DataNewFashion)
//                    binding.newFashion.layoutManager =
//                        LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//                }
//            }
//
//            override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {
//                Log.d(TAG, "onChildChanged: ${dataSnapshot.key}")
//
//                val newComment = dataSnapshot.getValue<Comment>()
//                val commentKey = dataSnapshot.key
//
//
//            }
//
//            override fun onChildRemoved(dataSnapshot: DataSnapshot) {
//                Log.d(ContentValues.TAG, "onChildRemoved:" + dataSnapshot.key!!)
//                val commentKey = dataSnapshot.key
//
//            }
//
//            override fun onChildMoved(dataSnapshot: DataSnapshot, previousChildName: String?) {
//                Log.d(ContentValues.TAG, "onChildMoved:" + dataSnapshot.key!!)
//                val movedComment = dataSnapshot.getValue<Comment>()
//                val commentKey = dataSnapshot.key
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                Log.w(ContentValues.TAG, "postComments:onCancelled", databaseError.toException())
//                Toast.makeText(context, "Failed to load comments.",
//                    Toast.LENGTH_SHORT).show()
//            }
//        }
//        database_NewFashion.addChildEventListener(childEventListener)

        database_NewFashion.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                Log.d("fragmentMen", "fragmentMen: datachange")
                for (postSnapshot in dataSnapshot.children) {
                    val data_new = postSnapshot.getValue(NewFashion::class.java)
                    val DataNewFashion = mutableListOf<NewFashion>()
                    if (data_new!=null){
                        DataNewFashion.add(data_new)
                        binding.newFashion.adapter = AdapterFragment_newFashion(DataNewFashion)
                        binding.newFashion.layoutManager =
                            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        })

    }


    // chuyen man san all product
    private fun allProduct() {
        val fragment_child = activity as ActivityMain
        fragment_child.change()
        onStop()
    }

    override fun onAttach(context: Context) {
        Log.d("fragmentMen", "fragmentMen: onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("fragmentMen", "fragmentMen: onCreate")
        super.onCreate(savedInstanceState)

    }

    override fun onPause() {
        Log.d("fragmentMen", "fragmentMen: onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("fragmentMen", "fragmentMen: onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("fragmentMen", "fragmentMen: onDestroy")
        super.onDestroy()
    }

    override fun onStart() {
        super.onStart()

        // khởi tạo các biến
        init()

        // SET EVEN BUTTON CLICK
        SetOnClick()

        // danh sách các bài báo về thời trang
        recycler_NewFashion()

        // các sản phẩm được gợi ý
        recycler_RecommendProduct()
    }


}