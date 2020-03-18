package com.example.weatherapp.network.models.weatherdata

import com.example.weatherapp.ui.detailscityweather.DetailedWeatherModel
import com.google.gson.annotations.SerializedName

data class WeatherData(@SerializedName("visibility")
                       val visibility: Int = 0,
                       @SerializedName("timezone")
                       val timezone: Int = 0,
                       @SerializedName("main")
                       val main: Main,
                       @SerializedName("clouds")
                       val clouds: Clouds,
                       @SerializedName("sys")
                       val sys: Sys,
                       @SerializedName("dt")
                       val dt: Int = 0,
                       @SerializedName("coord")
                       val coord: Coord,
                       @SerializedName("weather")
                       val weather: List<WeatherItem>?,
                       @SerializedName("name")
                       val name: String = "",
                       @SerializedName("cod")
                       val cod: Int = 0,
                       @SerializedName("id")
                       val id: Int = 0,
                       @SerializedName("base")
                       val base: String = "",
                       @SerializedName("wind")
                       val wind: Wind){

    fun toWeatherModel(cityNameS: String) : DetailedWeatherModel {
        val weather = this
        return DetailedWeatherModel().apply {
            cityName = cityNameS
            weatherDesc = weather.weather?.get(0)?.description ?: "No Info"
            pressure = weather.main.pressure
            temperature = weather.main.temp
            humidity = weather.main.humidity
            minTempDay = weather.main.tempMin
            maxTempDay = weather.main.tempMax
            windSpeed = weather.wind.speed
            iconWeather = weather.weather?.get(0)?.icon ?: "01d"
        }
    }
}
