package com.example.ttcs_shoppinng_mall.ui.activity

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast


import androidx.appcompat.app.AppCompatActivity
import com.example.ttcs_shoppinng_mall.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ActivityLogin : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        SetOnClick()
    }

    // set event button
    fun SetOnClick() {
//chuyển sang màn đăng ki
        binding.SingUp.setOnClickListener {
            Singup()
        }
// đăng nhập
        binding.SingIn.setOnClickListener {
            Login()
        }
// reset pasword
        binding.Forgot.setOnClickListener {
            ResetPassword()
        }


    }

    fun ResetPassword() {
        auth = Firebase.auth
        val email = binding.UserName.text.toString().trim()
        if (!email.isEmpty()) {
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val builder = AlertDialog.Builder(this)
                        builder.setTitle("success")
                        builder.setMessage("Check email và đổi mật khẩu")
                        builder.show()
                    }
                }
        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("ERROR")
            builder.setMessage("XIN VUI LÒNG NHẬP EMAIL Ở TÊN TÀI KHOẢN")
            builder.show()
        }
    }


    fun Login() {
        auth = Firebase.auth
        val user_name = binding.UserName.text.toString().trim()
        val user_password = binding.UserPassword.text.toString().trim()
        if (!user_name.isEmpty() && !user_password.isEmpty()){

            auth.signInWithEmailAndPassword(user_name, user_password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val user = auth.currentUser
                        val intent = Intent(this, ActivityMain::class.java)
                        startActivity(intent)
                    } else {

                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "sai tên đăng nhập hoặc mật khẩu",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

        } else {
            Toast.makeText(baseContext, "Không được để trống email hoặc password",
                Toast.LENGTH_SHORT).show()
        }

    }

    fun Singup() {
        val intent = Intent(this, ActivitySingup::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}