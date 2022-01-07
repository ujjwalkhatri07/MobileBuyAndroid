package com.ujjwal.wearables.response

import com.ujjwal.wearables.entity.User

data class LoginResponse(
    val success :Boolean? = null,
    val token : String? = null,
    val data: MutableList<User>? = null
)
