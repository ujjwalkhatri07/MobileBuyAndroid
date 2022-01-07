package com.ujjwal.mobileShop.repository

import android.util.Log
import com.ujjwal.mobileShop.api.ArticleAPI
import com.ujjwal.mobileShop.api.MyApiRequest
import com.ujjwal.mobileShop.api.ServiceBuilder
import com.ujjwal.mobileShop.dao.ArticleDAO
import com.ujjwal.mobileShop.entity.Article


class ArticleRepository  (private val articleDao: ArticleDAO): MyApiRequest() {
    private val articleAPI = ServiceBuilder.buildService(ArticleAPI::class.java)
//    suspend fun getAllArticles(): ArticleResponse {
//        return apiRequest {
//            articleAPI.getAllArticles()
//        }
//    }

    suspend fun displayAllArticles() : MutableList<Article>?{
        try {
            val response = apiRequest{articleAPI.getAllArticles()}
            saveInRoom(response.data!!)
            return articleDao.getAllArticles()
        }
        catch(ex:Exception){
            Log.d("repo",ex.toString())
        }
        return articleDao.getAllArticles()
    }

    private suspend fun saveInRoom(articles: MutableList<Article>){
        for (article in articles){
            articleDao.insertArticle(article)
        }
    }
}