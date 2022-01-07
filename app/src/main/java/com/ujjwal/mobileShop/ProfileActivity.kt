package com.ujjwal.mobileShop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.ujjwal.mobileShop.api.ServiceBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileActivity : AppCompatActivity() {
    private lateinit var tvUsername: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvContactno: TextView

    var name: String = ""
    var email: String = ""
    var contactno: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        tvUsername = findViewById(R.id.tvusername)
        tvEmail = findViewById(R.id.tvemail)
        tvContactno = findViewById(R.id.tvcontactno)

        getProfile()

        tvUsername.setText("Username: " + MainActivity.username);
        tvEmail.setText("Email: " + MainActivity.useremail);
        tvContactno.setText("Contact no: " + MainActivity.contact);
    }
    private fun getProfile() {
        val sharedPref = getSharedPreferences("UserDetails", MODE_PRIVATE)
        name = sharedPref.getString("name", "")!!
        email = sharedPref.getString("email", "")!!
        contactno = sharedPref.getString("contactno", "")!!
    }
//    private fun updateUser() {
//        val id= ServiceBuilder.id!!
//        Toast.makeText(requireContext(), ""+id, Toast.LENGTH_SHORT).show()
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val userRepository = CustomerRepository()
//                val user = Consumer(
//                        fullname =  etfullname.text.toString(),
//                        contact = etcontact.text.toString(),
//                        email = etemail.text.toString(),
//                        username = etusername.text.toString(),
//                        address = etaddress.text.toString()
//                )
//                val response = userRepository.updateUser(id, user)
//                if (response.success == true) {
//                    withContext(Dispatchers.Main) {
//                        Toast.makeText(
//                                context,
//                                "Updated successfully",
//                                Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//            } catch (ex: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(
//                            context,
//                            ex.localizedMessage,
//                            Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//        }
//    }
}