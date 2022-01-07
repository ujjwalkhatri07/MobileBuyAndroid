package com.ujjwal.wearables.api

import com.ujjwal.wearables.entity.User
import com.ujjwal.wearables.response.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface UserAPI {
    //Register user
    @POST("user/insert")
    suspend fun registerUser(
        @Body user: User
    ): Response<LoginResponse>


    //Login
    @FormUrlEncoded
    @POST("user/login")
    suspend fun checkUser(
        @Field("user_email") user_email:String,
        @Field("user_password") user_password:String
    ): Response<LoginResponse>

}
