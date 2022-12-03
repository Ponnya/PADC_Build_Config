package com.padc.ponnya.shared.data.models

import com.padc.ponnya.shared.data.vos.RestaurantVO

interface RestaurantModel {
    fun getRestaurants(
        onSuccess: (List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    )
}