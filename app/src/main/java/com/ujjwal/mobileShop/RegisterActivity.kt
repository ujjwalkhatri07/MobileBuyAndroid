package com.ujjwal.mobileShop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ujjwal.mobileShop.entity.User
import com.ujjwal.mobileShop.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class RegisterActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etContactno: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnSignup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_register)

        etName = findViewById(R.id.etname)
        etEmail = findViewById(R.id.etemail)
        etContactno = findViewById(R.id.etcontactno)
        etPassword = findViewById(R.id.etpassword)
        etConfirmPassword = findViewById(R.id.etcpassword)
        btnSignup = findViewById(R.id.btnSignup)
        btnSignup.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val contactno = etContactno.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (password != confirmPassword) {
                etPassword.error = "Password does not match"
                etPassword.requestFocus()
                return@setOnClickListener
            } else {
//                val user = User(name, email, contactno, password)
//                CoroutineScope(Dispatchers.IO).launch {
//                    UserDB.getInstance(this@RegisterActivity).getUserDAO().registerUser(user)
//
//                    withContext(Dispatchers.Main) {
//                        Toast.makeText(this@RegisterActivity, "User registered", Toast.LENGTH_SHORT).show()
//                    }
                val user = User(user_username=name, user_email=email, user_contactno=contactno, user_password=password)

                // Api code goes here
                CoroutineScope(Dispatchers.IO).launch{
                    try{
                        val repository = UserRepository()
                        val response = repository.registerUser(user)
                        if (response.success==true){
                            withContext(Dispatchers.Main){
                                Toast.makeText(this@RegisterActivity,"Registered",Toast.LENGTH_SHORT).show()
                            }
                        }
                    }catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@RegisterActivity, ex.toString(), Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
    }
}