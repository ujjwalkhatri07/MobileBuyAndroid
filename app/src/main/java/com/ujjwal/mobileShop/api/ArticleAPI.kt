package com.ujjwal.mobileShop.api

import com.ujjwal.mobileShop.response.ArticleResponse
import com.ujjwal.mobileShop.response.ImageResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface ArticleAPI {
    @GET("article/show")
    suspend fun getAllArticles(
//            @Header("Authorization") token:String,
    ) : Response<ArticleResponse>

    @Multipart
    @PUT("article/{id}/photo")
    suspend fun uploadImage(
            @Header("Authorization") token: String,
            @Path("id") id: String,
            @Part file: MultipartBody.Part
    ): Response<ImageResponse>
}