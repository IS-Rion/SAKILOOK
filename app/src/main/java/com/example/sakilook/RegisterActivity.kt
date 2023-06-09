package com.example.sakilook

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.sakilook.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = Firebase.auth
        val registerBtn = findViewById<Button>(R.id.registerBtn)
        val listener = OnClickRegister()
        registerBtn.setOnClickListener(listener)
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null) {
            reload()
        }
    }

    private inner class OnClickRegister: View.OnClickListener {
        var email = findViewById<EditText>(R.id.email).text
        var password = findViewById<EditText>(R.id.password).text
        override fun onClick(v: View?) {
            Log.d("onClickRegister", "Clicked")
            Log.d("email", email.toString())
            Log.d("password", password.toString())
            auth.createUserWithEmailAndPassword(email.toString(), password.toString())
                .addOnCompleteListener {task ->
                    Log.d("data", "register successful")
                    setContentView(R.layout.activity_register_success)
                }
        }
    }

    private fun reload(){}

}