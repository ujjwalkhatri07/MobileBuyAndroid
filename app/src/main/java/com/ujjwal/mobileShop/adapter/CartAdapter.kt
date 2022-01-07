package com.ujjwal.mobileShop.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ujjwal.mobileShop.R
import com.ujjwal.mobileShop.entity.Cart
import com.ujjwal.mobileShop.repository.CartRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CartAdapter (
    var listCart: MutableList<Cart>,
    val context: Context

): RecyclerView.Adapter<CartAdapter.CartViewHolder>(){
    class CartViewHolder(view: View): RecyclerView.ViewHolder(view){
        val productImg: ImageView
        val productName: TextView
        val productPrice: TextView
        val quantity: TextView
        val delete: ImageButton

        init {
            productImg=view.findViewById(R.id.imgProduct)
            productName=view.findViewById(R.id.tvProductName)
            productPrice=view.findViewById(R.id.tvProductPrice)
            quantity=view.findViewById(R.id.tvQuantity)
            delete = view.findViewById(R.id.ibDelete)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_cart_layout,parent,false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder,  position: Int) {
        val cart = listCart[position]
        val imguri = "http://10.0.2.2:90/" + cart.product!!.product_img!!.replace("\\","/")
        //Log.d(Companion.TAG, "onBindViewHolder: " + cart)
        //        val splitProduct = product.split(" : ")
        //Log.d("nametest", "onBindViewHolder: " + cart.productId!!.product_name)
        holder.productName.text = cart.product.product_name
        //Log.d("nametest", "onBindViewHolder: " + holder.productName.text)
        holder.productPrice.text = "Price: Rs. ${cart.product.product_price}"
        holder.quantity.text = "Quantity "+ cart.quantity.toString()
        Glide.with(context).load(imguri).into(holder.productImg)

        holder.delete.setOnClickListener{
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val repository = CartRepository()
                        val token = getSharedPref()
                        Log.d("idtesting1", "onBindViewHolder: " + cart._id)
                        val response = repository.deleteCart(cart._id!!,"Bearer "+ token)
                        Log.d("idtesting", "onBindViewHolder: " + response)
                        listCart=response.data!!
                        Log.d("deleting", response.success.toString())
                        notifyDataSetChanged()

                        if (response.success == true) {
                            withContext(Dispatchers.Main) {
//                              Log.d("Tag", "onCreateView: "+ listCart.size)size
                                Toast.makeText(context, "Product deleted", Toast.LENGTH_SHORT).show()
                                notifyDataSetChanged()
                            }
                        }

                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()

                        }
                    }
                }
        }}




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
