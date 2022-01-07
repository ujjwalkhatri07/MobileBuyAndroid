package com.ujjwal.mobileShop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ujjwal.mobileShop.adapter.CheckoutAdapter
import com.ujjwal.mobileShop.entity.Cart
import com.ujjwal.mobileShop.repository.CartRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CheckoutActivity : AppCompatActivity() {
    private lateinit var checkoutView: RecyclerView
    private lateinit var btnOrder: Button
    var cartList= mutableListOf<Cart>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        checkoutView = findViewById(R.id.checkoutRecycler)
        btnOrder = findViewById(R.id.btnOrder)
        btnOrder.setOnClickListener {
            Toast.makeText(this, "Order has been placed.", Toast.LENGTH_SHORT).show()
        }
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = CartRepository()
//                Log.d("repotest", "onBindViewHolder: " + repository)
                val token = getSharedPref()
//                Log.d("tokentest", "onBindViewHolder: " + token)
                val response = repository.getCart("Bearer "+token!!)
                Log.d("resptest", "onBindViewHolder: " + response)
                cartList=response.data!!
                Log.d("CARTLIST", response.success.toString())
                if (response.success == true) {
                    withContext(Dispatchers.Main) {
                        var adapter = CheckoutAdapter(cartList, this@CheckoutActivity)
                        checkoutView.layoutManager= LinearLayoutManager(this@CheckoutActivity)
                        checkoutView.adapter=adapter
                    }
                }
            }
            catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@CheckoutActivity, ex.toString(), Toast.LENGTH_SHORT).show()

                }
            }

        }

    }
    private fun getSharedPref():String {
        val sharedPref = getSharedPreferences("LoginPref", AppCompatActivity.MODE_PRIVATE)
        return sharedPref?.getString("token", "")!!
    }
}