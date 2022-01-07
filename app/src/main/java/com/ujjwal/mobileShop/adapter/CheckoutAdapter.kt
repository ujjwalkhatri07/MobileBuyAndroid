package com.ujjwal.mobileShop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ujjwal.mobileShop.R
import com.ujjwal.mobileShop.entity.Cart

class CheckoutAdapter (
    var listCart: MutableList<Cart>,
    val context: Context,
    var GrandTotal: Int = 0
    ): RecyclerView.Adapter<CheckoutAdapter.CheckoutViewHolder>(){
    class CheckoutViewHolder(view: View): RecyclerView.ViewHolder(view){
        val productName: TextView
        val productPrice: TextView
        val quantity: TextView
        val QXP: TextView


        init {
            productName=view.findViewById(R.id.tvProductName)
            productPrice=view.findViewById(R.id.tvProductPrice)
            quantity=view.findViewById(R.id.tvQuantity)
            QXP=view.findViewById(R.id.tvQXP)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_checkout_layout,parent,false)
        return CheckoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: CheckoutViewHolder,  position: Int) {
        val cart = listCart[position]
        //Log.d(Companion.TAG, "onBindViewHolder: " + cart)
        //        val splitProduct = product.split(" : ")
        //Log.d("nametest", "onBindViewHolder: " + cart.productId!!.product_name)
        holder.productName.text = cart.product!!.product_name
        //Log.d("nametest", "onBindViewHolder: " + holder.productName.text)
        holder.productPrice.text = cart.product!!.product_price
        holder.quantity.text = cart.quantity.toString()
        val Total:Int = holder.productPrice.text.toString().toInt() * holder.quantity.text.toString()
            .toInt()
        holder.QXP.text = "Total:"+ Total.toString()

        GrandTotal = GrandTotal + Total



    }




    override fun getItemCount(): Int {
        return listCart.size
    }

    private fun getSharedPref():String {
        val sharedPref = context?.getSharedPreferences("LoginPref", AppCompatActivity.MODE_PRIVATE)
        return sharedPref?.getString("token", "")!!
    }
    companion object {
        private const val TAG = "CartAdapter"
    }
}