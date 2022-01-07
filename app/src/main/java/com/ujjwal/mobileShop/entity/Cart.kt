package com.ujjwal.mobileShop.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Cart(
    val _id: String? = null,
    val user: String?=null,
    val product: Product?= null,
    val quantity: Int? = 0
){
    @PrimaryKey(autoGenerate = true)
    var cartId:Int=0
}
