package com.ujjwal.mobileShop.response

import com.ujjwal.mobileShop.entity.Article

data class ArticleResponse(
        val success : Boolean? = null,
        val data: MutableList<Article>? = null
)
