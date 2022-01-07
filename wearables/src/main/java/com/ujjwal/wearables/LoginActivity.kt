package com.ujjwal.wearables

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.ujjwal.wearables.api.ServiceBuilder
import com.ujjwal.wearables.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : WearableActivity() {

    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnLogin : Button
    companion object {
        var useremail = "";
        var username = "";
        var contact = "";
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.etemail)
        etPassword = findViewById(R.id.etpassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener{
            login()

        }


        // Enables Always-on
        setAmbientEnabled()
    }
    private fun login() {
        startActivity(
            Intent(
                this@LoginActivity,
                DashActivity::class.java
            )
        )
    }
}