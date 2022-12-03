package com.padc.ponnya.shared.mvp.views

import com.padc.ponnya.shared.data.vos.RestaurantVO

interface MainView {
    fun showRestaurants(data: List<RestaurantVO>)
    fun showError(error: String)
}