package com.ujjwal.mobileShop.entity

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
):Parcelable{
    @PrimaryKey
    var userId: Int? = null
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(user_username)
        parcel.writeString(user_email)
        parcel.writeString(user_contactno)
        parcel.writeString(user_password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}