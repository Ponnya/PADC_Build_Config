package com.padc.ponnya.padcbuildconfig

import android.app.Application
import com.padc.ponnya.shared.data.models.RestaurantModelImpl

class FoodDeliveryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        RestaurantModelImpl.initRetrofitWithBaseUrl(BuildConfig.ENDPOINT)
    }
}