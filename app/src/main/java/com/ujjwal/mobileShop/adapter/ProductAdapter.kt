package com.ujjwal.mobileShop.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ujjwal.mobileShop.R
import com.ujjwal.mobileShop.entity.Product
import com.ujjwal.mobileShop.ViewSingleProductActivity

class ProductAdapter (


    val context: Context,
    ): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
    var lstProducts= emptyList<Product>()

    fun setList(list: List<Product>){
        lstProducts = list
        notifyDataSetChanged()
    }

        class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tvProductName: TextView = view.findViewById(R.id.tvProductName)
            val imgProduct: ImageView
            init{
                imgProduct = view.findViewById(R.id.imgProduct)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.custom_product_layout, parent, false)
            return ProductViewHolder(view)
        }

        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
            val product = lstProducts[position]
            holder.tvProductName.text = product.product_name
            holder.tvProductName.setOnClickListener{
                val id= product._id
                val intent = Intent(context,ViewSingleProductActivity::class.java)
                context.startActivity(intent.putExtra("product",id))
            }
            holder.imgProduct.setOnClickListener{
                val id= product._id
                val intent = Intent(context,ViewSingleProductActivity::class.java)
                context.startActivity(intent.putExtra("product",id))
            }
            val imguri = "http://10.0.2.2:90/" + product.product_img!!.replace("\\","/")
//            Log.d("IMGURI", "onBindViewHolder: " + imguri)
//            Log.d("TAG", "onBindViewHolder: " + product.product_img)
            Glide.with(context).load(imguri).into(holder.imgProduct)

        }
        override fun getItemCount(): Int {
            return lstProducts.size
        }
}