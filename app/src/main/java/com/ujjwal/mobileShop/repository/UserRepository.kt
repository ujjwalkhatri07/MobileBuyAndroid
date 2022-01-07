package com.ujjwal.mobileShop.repository

import com.ujjwal.mobileShop.api.MyApiRequest
import com.ujjwal.mobileShop.api.ServiceBuilder
import com.ujjwal.mobileShop.api.UserAPI
import com.ujjwal.mobileShop.entity.User
import com.ujjwal.mobileShop.response.LoginResponse

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

    //Retrieve User
    suspend fun userDetails(token:String,userToken:String): LoginResponse {
        return apiRequest {
            userAPI.retrieveUser(ServiceBuilder.token!!,userToken)
        }
    }

}