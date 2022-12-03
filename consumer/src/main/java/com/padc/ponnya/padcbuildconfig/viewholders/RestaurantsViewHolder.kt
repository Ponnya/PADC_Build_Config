package com.padc.ponnya.padcbuildconfig.viewholders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.ponnya.padcbuildconfig.databinding.ViewHolderRestaurantsBinding
import com.padc.ponnya.shared.data.vos.RestaurantVO

class RestaurantsViewHolder(private val binding: ViewHolderRestaurantsBinding) : RecyclerView.ViewHolder(binding.root){
    @SuppressLint("SetTextI18n")
    fun dataBind(data:RestaurantVO){
        Glide.with(binding.root)
            .load(data.imageUrl)
            .into(binding.ivRestaurant)

        binding.tvRestaurantName.text= data.name
        binding.tvRestaurantCategory.text = data.category
        binding.tvAmount.text = "${data.deliveryPrice}  MMK"
        binding.tvRating.text = data.rating.toString()
    }
}