package com.ujjwal.mobileShop.api

import com.ujjwal.mobileShop.response.CartResponse
import retrofit2.Response
import retrofit2.http.*

interface CartAPI {
    @FormUrlEncoded
    @POST("cart/insert/")
    suspend fun insertCart(
        @Header("Authorization") token:String,

        @Field("productId") productId:String
    ): Response<CartResponse>

    //retrieve Cart
    @GET("cart/")
    suspend fun retrieveCart(
        @Header("Authorization") token: String
    ):Response<CartResponse>

//    //Update
//    @FormUrlEncoded
//    @PUT("cart/{cart_id}")
//    suspend fun updateCart(
//        //@Header("Authorization") token:String,
//        @Path("cart_id") cart_id: String,
//        @Field("quantity") quantity: Int,
//
//        ):Response<CartResponse>


    //delete Cart
    @DELETE("cart/{id}")
    suspend fun deleteCart(
        @Header("Authorization") token:String,
        @Path("id") id: String

    ):Response<CartResponse>

}