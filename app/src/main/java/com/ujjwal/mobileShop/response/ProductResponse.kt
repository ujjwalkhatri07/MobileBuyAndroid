package com.ujjwal.mobileShop.response


import com.ujjwal.mobileShop.entity.Product

data class ProductResponse(
        val success : Boolean? = null,
        val data: MutableList<Product>? = null
)
