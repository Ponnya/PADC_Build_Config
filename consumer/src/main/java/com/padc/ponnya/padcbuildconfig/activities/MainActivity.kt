package com.padc.ponnya.padcbuildconfig.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.padcbuildconfig.adapters.RestaurantsAdapter
import com.padc.ponnya.padcbuildconfig.databinding.ActivityMainBinding
import com.padc.ponnya.shared.data.vos.RestaurantVO
import com.padc.ponnya.shared.mvp.presenters.MainPresenter
import com.padc.ponnya.shared.mvp.presenters.MainPresenterImpl
import com.padc.ponnya.shared.mvp.views.MainView
import com.padc.ponnya.shared.showSnackBar

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mPresenter: MainPresenter
    private lateinit var restaurantsAdapter: RestaurantsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpPresenter()
        setUpToolbar()
        setUpRecyclerView()

        mPresenter.onUiReady()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Welcome"
    }

    private fun setUpRecyclerView() {
        restaurantsAdapter = RestaurantsAdapter()
        with(binding.rvRestaurants) {
            this.adapter = restaurantsAdapter
            this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun showRestaurants(data: List<RestaurantVO>) {
        restaurantsAdapter.setNewData(data)
    }

    override fun showError(error: String) {
        showSnackBar(error)
    }
}