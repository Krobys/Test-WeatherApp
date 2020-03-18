package com.example.weatherapp.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters{

    @BindingAdapter(value = ["imageUrl"])
    @JvmStatic
    fun loadWeatherImage(view: ImageView, imageCode: String?) {
            Glide.with(view)
                .load("https://openweathermap.org/img/wn/$imageCode@2x.png")
                .into(view)
    }

}