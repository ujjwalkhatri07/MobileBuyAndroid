package com.ujjwal.mobileShop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_splash)

        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            if(getSharedPreferences()) {
                startActivity(
                        Intent(
                                this@SplashActivity,
                                DashboardActivity::class.java
                        )
                )
            }
            else {
                startActivity(
                        Intent(
                                this@SplashActivity,
                                MainActivity::class.java
                        )
                )
            }
            finish()
        }
    }

    private fun getSharedPreferences():Boolean{
        val sharedPref = getSharedPreferences("LoginPref", MODE_PRIVATE)
        val username = sharedPref.getString("username", "")
        val password = sharedPref.getString("password", "")
        return username != "" && password != ""
    }
}