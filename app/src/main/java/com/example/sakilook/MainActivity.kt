package com.example.sakilook

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val registerBtn = findViewById<Button>(R.id.registerBtn)
        val loginListener = OnClickLogin()
        val registerListener = OnClickRegister()
        loginBtn.setOnClickListener(loginListener)
        registerBtn.setOnClickListener(registerListener)
    }

    private inner class OnClickRegister: OnClickListener {
        override fun onClick(v: View?) {
            Log.d("OnClickRegister", "Clicked")
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private inner class OnClickLogin: OnClickListener {
        override fun onClick(v: View?) {
            Log.d("OnClickLogin", "clicked")
        }
    }


}