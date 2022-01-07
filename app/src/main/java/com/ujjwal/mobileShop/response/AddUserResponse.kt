package com.ujjwal.mobileShop.response

import com.ujjwal.mobileShop.entity.User

data class AddUserResponse(
    val success: Boolean?=null,
    val data : User?= null
)
