package com.example.weatherapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.ui.detailscityweather.DetailedWeatherModel
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface WeatherDao {

    @Query("SELECT * FROM detailedWeather")
    fun getLastWeatherData(): Observable<List<DetailedWeatherModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLastWeatherData(weatherData: DetailedWeatherModel): Completable

}