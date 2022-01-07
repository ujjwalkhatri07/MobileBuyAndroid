package com.ujjwal.mobileShop.response


import com.ujjwal.mobileShop.entity.User

data class LoginResponse(
    val success :Boolean? = null,
    val token : String? = null,
    val data: User? = null
)
