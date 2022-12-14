package com.padc.ponnya.rider

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

fun sendNotification(context: Context, body: String, title: String, pendingIntent: PendingIntent) {
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    val NOTIFICATION_CHANNEL_ID = BuildConfig.APPLICATION_ID + ".channel"

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "rider"
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            name,
            NotificationManager.IMPORTANCE_HIGH
        )

        notificationManager.createNotificationChannel(channel)
    }

    val notification =
        buildNotification(context, NOTIFICATION_CHANNEL_ID, title, body, pendingIntent)

    notificationManager.notify(getUniqueId(), notification)
}

private fun buildNotification(
    context: Context,
    channelId: String,
    title: String,
    content: String,
    pendingIntent: PendingIntent
): Notification {
    val bigTextStyle = NotificationCompat.BigTextStyle()

    bigTextStyle.bigText(content)
    bigTextStyle.setBigContentTitle("This is a big title")

    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setContentText(title)
        .setAutoCancel(true)
        .setStyle(bigTextStyle)
        .setContentIntent(pendingIntent)
        .build()
}

private fun getUniqueId() = (System.currentTimeMillis() % 1000).toInt()