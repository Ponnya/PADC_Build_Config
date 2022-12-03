package com.padc.ponnya.shared.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padc.ponnya.shared.data.models.RestaurantModelImpl
import com.padc.ponnya.shared.mvp.views.MainView

class MainPresenterImpl : ViewModel(), MainPresenter {

    private lateinit var mView: MainView
    private val mModel = RestaurantModelImpl
    override fun initView(view: MainView) {
        mView = view
    }

    override fun onUiReady() {
        mModel.getRestaurants(
            { mView.showRestaurants(it) },
            { mView.showError(it) },
        )
    }
}