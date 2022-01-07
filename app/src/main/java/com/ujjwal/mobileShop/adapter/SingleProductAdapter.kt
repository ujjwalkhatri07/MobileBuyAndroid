package com.ujjwal.mobileShop.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ujjwal.mobileShop.Notifications.Notification
import com.ujjwal.mobileShop.R
import com.ujjwal.mobileShop.entity.Product
import com.ujjwal.mobileShop.repository.CartRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SingleProductAdapter (
    private val lstProducts: List<Product>,
    private val context: Context,
    ): RecyclerView.Adapter<SingleProductAdapter.SingleProductViewHolder>() {
    class SingleProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvProductName: TextView = view.findViewById(R.id.tvProductName)
        val tvProductPrice: TextView = view.findViewById(R.id.tvProductPrice)
        val tvProductDesc: TextView = view.findViewById(R.id.tvProductDesc)
        val btnAddToCart: Button = view.findViewById(R.id.btnAddToCart)
        val imgProduct: ImageView
        init {
            imgProduct = view.findViewById(R.id.imgProduct)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_single_product_layout, parent, false)
        return SingleProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: SingleProductViewHolder, position: Int) {
        val product = lstProducts[position]
        holder.tvProductName.text = product.product_name

        val imguri = "http://10.0.2.2:90/" + product.product_img!!.replace("\\", "/")
        Glide.with(context).load(imguri).into(holder.imgProduct)

        holder.tvProductDesc.text = "Description:  "+product.product_desc
        holder.tvProductPrice.text = "Price:  "+product.product_price

        holder.btnAddToCart.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                try {
//                    val cart = Cart(productData.productImage, productData.productName, productData.productPrice, productData.quantity)

//                    CartDB.getInstance(context).getCartDAO().insertCart(cart)
                    val repository = CartRepository()
                    val token = getSharedPref()
                    val response = repository.addTocart(product._id!!,"Bearer "+ token!!)
                    if (response.success == true) {
                        withContext(Dispatchers.Main) {
                            addtocartNotification()
                            Toast.makeText(context, "Product Added To Cart !", Toast.LENGTH_SHORT).show()
                        }
                    }

                } catch (ex: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, ex.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return lstProducts.size
    }

    private fun addtocartNotification() {

        val notificationManager = NotificationManagerCompat.from(context)

        val notificationChannels = Notification(context)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(context, notificationChannels.addtocart)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle("Adopt. Dont Shop")
            .setContentText("Product Added to Cart")
            .setColor(Color.BLACK)
            .build()
        notificationManager.notify(1, notification)
    }


    private fun getSharedPref():String {
        val sharedPref = context?.getSharedPreferences("LoginPref", AppCompatActivity.MODE_PRIVATE)
        return sharedPref?.getString("token", "")!!
    }
}
