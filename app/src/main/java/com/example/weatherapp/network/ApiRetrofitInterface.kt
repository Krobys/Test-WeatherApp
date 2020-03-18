package com.example.weatherapp.network

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.network.models.weatherdata.WeatherData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRetrofitInterface {

    @GET("weather")
    fun getWeatherForCity(@Query("q") cityName: String,
                          @Query("appid") apiKey: String = BuildConfig.API_KEY,
                          @Query("lang") language: String = "ru",
                          @Query("mode") format: String = "json",
                          @Query("units") units: String = "metric"): Single<WeatherData>

//    @GET("weather?q=Kherson&appid=064e26375fe2ac5bc2f2b4225c26be41&lang=ru&units=metric")
//    fun getWeatherForCity(@Query("city") cityName: String = "test"): Single<WeatherData>

    //https://api.openweathermap.org/data/2.5/weather?q=Kherson&appid=064e26375fe2ac5bc2f2b4225c26be41&lang=ru&units=metric
}
