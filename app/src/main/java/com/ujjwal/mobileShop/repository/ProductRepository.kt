package com.ujjwal.mobileShop.repository

import android.util.Log
import com.ujjwal.mobileShop.api.MyApiRequest
import com.ujjwal.mobileShop.api.ProductAPI
import com.ujjwal.mobileShop.api.ServiceBuilder
import com.ujjwal.mobileShop.dao.ProductDAO
import com.ujjwal.mobileShop.entity.Product


class ProductRepository (private val productDao: ProductDAO): MyApiRequest() {
    private val productAPI = ServiceBuilder.buildService(ProductAPI::class.java)
//    suspend fun getAllProducts(): ProductResponse {
//        return apiRequest {
//            productAPI.getAllProducts()
//        }
//    }

    suspend fun displayAllProducts() : MutableList<Product>?{
        try {
            val response = apiRequest{productAPI.getAllProducts()}
            saveInRoom(response.data!!)
            return productDao.getAllProducts()
        }
        catch(ex:Exception){
            Log.d("repo",ex.toString())
        }
        return productDao.getAllProducts()
    }

    private suspend fun saveInRoom(products: MutableList<Product>){
        for (product in products){
            productDao.insertProduct(product)
        }
    }
}