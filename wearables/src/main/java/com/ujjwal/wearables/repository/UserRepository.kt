package com.ujjwal.wearables.repository

import com.ujjwal.wearables.api.MyApiRequest
import com.ujjwal.wearables.api.ServiceBuilder
import com.ujjwal.wearables.api.UserAPI
import com.ujjwal.wearables.entity.User
import com.ujjwal.wearables.response.LoginResponse

class UserRepository : MyApiRequest() {
    private val userAPI = ServiceBuilder.buildService(UserAPI::class.java)

    suspend fun registerUser(user: User): LoginResponse {
        return apiRequest {
            userAPI.registerUser(user)
        }
    }

    suspend fun checkUser(user_email: String, user_password: String):LoginResponse{
        return apiRequest {
            userAPI.checkUser(user_email, user_password)
        }
    }


}