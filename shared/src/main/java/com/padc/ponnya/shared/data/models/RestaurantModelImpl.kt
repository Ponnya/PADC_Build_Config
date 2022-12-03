package com.padc.ponnya.shared.data.models

import com.padc.ponnya.shared.data.vos.RestaurantVO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object RestaurantModelImpl : RestaurantModel, BaseModel() {
    override fun getRestaurants(
        onSuccess: (List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mApi.getRestaurant()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { onSuccess(it.data ?: listOf()) }, { onFailure(it.localizedMessage ?: "") }
            )
    }
}