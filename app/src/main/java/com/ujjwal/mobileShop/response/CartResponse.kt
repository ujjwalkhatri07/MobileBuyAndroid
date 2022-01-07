package com.ujjwal.mobileShop.response

import com.ujjwal.mobileShop.entity.Cart

data class CartResponse (
    val success: Boolean? = null,
    val data: MutableList<Cart>? = null
)