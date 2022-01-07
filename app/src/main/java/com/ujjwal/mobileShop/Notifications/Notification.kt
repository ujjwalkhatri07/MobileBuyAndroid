package com.ujjwal.mobileShop.Notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class Notification(val context: Context) {
    val addtocart: String ="Added to Cart"


    fun createNotificationChannels(){
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                addtocart,"Added to Cart", NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "This is channel "


            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager

            notificationManager.createNotificationChannel(channel)


        }
    }
}