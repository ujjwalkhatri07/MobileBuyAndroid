package com.ujjwal.mobileShop

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class UpdateUserActivity : AppCompatActivity() {

    var name : String=""
    var email: String=""
    var contactno : String=""
    var token = "";

    private lateinit var etupname: EditText
    private lateinit var etupemail:EditText
    private lateinit var etupcontactno:EditText
    private lateinit var btnUpdate: Button

    var sharedPreference: SharedPreferences? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user)

        etupname=findViewById(R.id.etupname)
        etupemail=findViewById(R.id.etupemail)
        etupcontactno=findViewById(R.id.etupcontactno)
        btnUpdate=findViewById(R.id.btnUpdateLink)

        getUserDetails()
        etupname.setText(name)
        etupemail.setText(email)
        etupcontactno.setText(contactno)

        sharedPreference = getSharedPreferences("LoginPref",
            AppCompatActivity.MODE_PRIVATE);
        token = sharedPreference?.getString("token", "")!!
    }

    private fun getUserDetails() {
        val sharedPref = getSharedPreferences("UserDetails", MODE_PRIVATE)
        name = sharedPref.getString("name", "")!!
        email = sharedPref.getString("email", "")!!
        contactno= sharedPref.getString("contactno", "")!!
    }

}