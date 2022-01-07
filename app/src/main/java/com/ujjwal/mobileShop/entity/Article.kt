package com.ujjwal.mobileShop.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
        @PrimaryKey()
        val _id : String,
        var article_title : String? =null,
        var article_body : String? =null,
)