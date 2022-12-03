package com.padc.ponnya.shared.network

import com.padc.ponnya.shared.network.responses.GetRestaurantsResponse
import com.padc.ponnya.shared.utils.API_GET_RESTAURANTS
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface RestaurantApi {
    @GET(API_GET_RESTAURANTS)
    fun getRestaurant():Observable<GetRestaurantsResponse>
}