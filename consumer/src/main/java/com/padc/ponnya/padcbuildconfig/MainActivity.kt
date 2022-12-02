package com.padc.ponnya.padcbuildconfig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.padc.ponnya.shared.showSnackBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showSnackBar("This is consumer app")
    }
}