package com.sabinhantu.caloriecounter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.sabinhantu.caloriecounter.Auth.AuthActivity


class MainActivity : AppCompatActivity() {

//    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mAuth = FirebaseAuth.getInstance()


    }

    override fun onStart() {
        super.onStart()

        var user = FirebaseAuth.getInstance().currentUser

        if (user == null) {
            intentToAuthActivity()
        }
    }

    fun intentToAuthActivity() {
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
    }
}
