package com.ujjwal.mobileShop.repository

import com.ujjwal.mobileShop.api.MyApiRequest
import com.ujjwal.mobileShop.api.ServiceBuilder
import com.ujjwal.mobileShop.api.SingleProductAPI
import com.ujjwal.mobileShop.response.ProductResponse

class SingleProductRepository: MyApiRequest() {
    private val singleProductAPI = ServiceBuilder.buildService(SingleProductAPI::class.java)

    //Display Single Product
    suspend fun getSingleProduct(id:String):ProductResponse{
        return apiRequest {
            singleProductAPI.showSingleProduct(id)
        }
    }
}