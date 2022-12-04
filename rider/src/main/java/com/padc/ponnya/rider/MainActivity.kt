package com.padc.ponnya.rider

import android.app.PendingIntent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padc.ponnya.shared.showSnackBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showSnackBar("This is Rider App")
        sendNotification(
            this,
            "You use this to refer to a person or thing that is near you, especially when you touch them or point to them. When there are two or more people or things",
            "Hello",
            PendingIntent.getActivity(
                this,
                0,
                DetailActivity.newIntent(this),
                PendingIntent.FLAG_UPDATE_CURRENT
            )
        )
    }
}