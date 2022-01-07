package com.ujjwal.mobileShop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ujjwal.mobileShop.dao.UserDAO
import com.ujjwal.mobileShop.entity.User

@Database(
    entities = [(User::class)],
    version = 1,
    exportSchema = false
)
abstract class UserDB : RoomDatabase(){

    abstract fun getUserDAO() : UserDAO

    companion object{
        @Volatile
        private var instance : UserDB? = null

        fun getInstance(context : Context) : UserDB{
            if(instance == null){
                synchronized(UserDB::class){
                    instance = buildDatabase(context)
                }
            }

            return instance!!
        }

        private fun buildDatabase(context : Context) =
            Room.databaseBuilder(
                context.applicationContext,
                UserDB::class.java,
                "UserDatabase"
            ).build()

    }
}