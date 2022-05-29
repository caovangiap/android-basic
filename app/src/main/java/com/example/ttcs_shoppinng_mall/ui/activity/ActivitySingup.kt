package com.example.ttcs_shoppinng_mall.ui.activity

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.example.ttcs_shoppinng_mall.databinding.ActivitySingupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ActivitySingup :AppCompatActivity() {

    lateinit var binding : ActivitySingupBinding
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // setup sự kiện các button
        Setonclick()
    }

    fun Setonclick(){
        // quay trở về màn đăng nhập
        binding.backtoLongin.setOnClickListener {
            onBackPressed()
        }
        // set sự kiện đăng kí
        binding.SingUp.setOnClickListener {
            Singup()
        }


    }
    // hàm đăng kí tài khoản
    fun Singup(){
        val user_name = binding.UserName.text.toString().trim()
        val user_password = binding.UserPassword.text.toString().trim()
        val check = binding.CheckPassword.text.toString().trim()

        auth = Firebase.auth

        if (!user_name.isEmpty() && !user_password.isEmpty() && check==user_password ){
            auth.createUserWithEmailAndPassword(user_name, user_password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        onBackPressed()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "mật khẩu có độ dài ít nhất 6 kí tự ",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }
        if (!user_name.isEmpty() && !user_password.isEmpty() && check!=user_password ){
            Toast.makeText(baseContext, "xin vui lòng nhập lại password trùng với password đã tạo ",
                Toast.LENGTH_SHORT).show()
        }

        else {
            Toast.makeText(baseContext, "Không được để trống email hoặc password",
                Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }
    override fun onDestroy() {
        super.onDestroy()
    }


}