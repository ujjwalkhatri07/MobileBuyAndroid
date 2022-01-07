package com.ujjwal.mobileShop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ujjwal.mobileShop.adapter.SingleProductAdapter
import com.ujjwal.mobileShop.repository.SingleProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewSingleProductActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_view_single_product)

        recyclerView = findViewById(R.id.singleproductRecycler)

        loadSingleProduct()
    }

    private fun loadSingleProduct() {
        CoroutineScope(Dispatchers.IO).launch{
            try {
                var id =intent.getStringExtra("product")
//                Log.d("IDchaiyeko", "onBindViewHolder: " + id)
                val repository = SingleProductRepository()
//                Log.d("repotest", "onBindViewHolder: " + repository)
                val response = repository.getSingleProduct(id!!)
//                Log.d("Datataneko1", "onBindViewHolder: " + repository.getSingleProduct(id!!))
                if(response.success == true){
                    val lstProduct = response.data
//                    Log.d("Datataneko", "onBindViewHolder: " + lstProduct)
                    withContext(Dispatchers.Main){
                        recyclerView.adapter = SingleProductAdapter(
                            lstProduct!!,
                            this@ViewSingleProductActivity
                        )
                        recyclerView.layoutManager=LinearLayoutManager(
                            this@ViewSingleProductActivity,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                    }
                }
            }
            catch(ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                            this@ViewSingleProductActivity,
                            ex.toString(),
                            Toast.LENGTH_SHORT
                    ).show()
//                    Log.d("DataAAyena", "khai k ho")
                }
    }
}}
}