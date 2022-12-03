package com.padc.ponnya.shared.mvp.presenters

import com.padc.ponnya.shared.mvp.views.MainView

interface MainPresenter {
    fun initView(view: MainView)
    fun onUiReady()
}