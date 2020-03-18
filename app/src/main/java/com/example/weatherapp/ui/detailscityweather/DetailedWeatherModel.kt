package com.example.weatherapp.ui.detailscityweather

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detailedWeather")
class DetailedWeatherModel {

    //@PrimaryKey(autoGenerate = true)
    @PrimaryKey
    var id = 0
    @ColumnInfo
    var cityName = ""
    @ColumnInfo
    var weatherDesc = ""
    @ColumnInfo
    var pressure = 0.0
    @ColumnInfo
    var temperature = 0.0
    @ColumnInfo
    var humidity = 0.0
    @ColumnInfo
    var minTempDay = 0.0
    @ColumnInfo
    var maxTempDay = 0.0
    @ColumnInfo
    var windSpeed = 0.0
    @ColumnInfo
    var iconWeather = ""
}