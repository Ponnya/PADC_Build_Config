package com.padc.ponnya.shared.network.responses

import com.google.gson.annotations.SerializedName
import com.padc.ponnya.shared.data.vos.RestaurantVO

data class GetRestaurantsResponse(
    @SerializedName("data")
    val data: List<RestaurantVO>?,
)