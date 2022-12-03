package com.padc.ponnya.padcbuildconfig.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.padcbuildconfig.databinding.ViewHolderRestaurantsBinding
import com.padc.ponnya.padcbuildconfig.viewholders.RestaurantsViewHolder
import com.padc.ponnya.shared.data.vos.RestaurantVO

class RestaurantsAdapter: RecyclerView.Adapter<RestaurantsViewHolder>() {

    private var mData: List<RestaurantVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val view =
            ViewHolderRestaurantsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        if (mData.isNotEmpty()) {
            holder.dataBind(mData[position])
        }

    }


    override fun getItemCount(): Int = mData.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(data: List<RestaurantVO>) {
        mData = data
        notifyDataSetChanged()
    }
}