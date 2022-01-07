package com.ujjwal.mobileShop.repository

import com.ujjwal.mobileShop.api.MyApiRequest
import com.ujjwal.mobileShop.api.ServiceBuilder
import com.ujjwal.mobileShop.api.SingleArticleAPI

import com.ujjwal.mobileShop.response.ArticleResponse


class SingleArticleRepository: MyApiRequest() {
    private val singleArticleAPI = ServiceBuilder.buildService(SingleArticleAPI::class.java)

    //Display Single Article
    suspend fun getSingleArticle(id:String): ArticleResponse {
        return apiRequest {
            singleArticleAPI.showSingleArticle(id)
        }
    }
}