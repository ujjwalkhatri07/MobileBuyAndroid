package com.ujjwal.wearables.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    val _id : String? = null,
    var user_username : String? =null,
    var user_email : String? =null,
    var user_contactno : String? = null,
    var user_password : String? =null
)

