package com.example.weatherapp.ui.detailscityweather

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.WeatherApplication
import com.example.weatherapp.base.BaseViewModel
import com.example.weatherapp.database.WeatherDao
import com.example.weatherapp.network.ApiRetrofitInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailedWeatherViewModel@Inject constructor(application: WeatherApplication) : BaseViewModel(application) {
    @Inject
    lateinit var weatherDao: WeatherDao
    @Inject
    lateinit var retrofitInterface: ApiRetrofitInterface
    var liveDataWeather: MutableLiveData<DetailedWeatherModel?> = MutableLiveData()

    fun getWeatherForCity(cityName: String) : MutableLiveData<DetailedWeatherModel?> {
        disposable += retrofitInterface.getWeatherForCity(cityName = cityName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onSuccess = {
                val weatherModel = it.toWeatherModel(cityName)
                saveWeatherToDatabase(weatherModel)
                liveDataWeather.value = weatherModel
            }, onError = {
                disposable += weatherDao.getLastWeatherData()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe{weatherList ->
                        if (weatherList.isNotEmpty() && weatherList[0].cityName == cityName){
                            liveDataWeather.value = weatherList[0]
                        }else{
                            liveDataWeather.value = null
                        }
                    }
            })

        return liveDataWeather
    }

    private fun saveWeatherToDatabase(detailedWeatherModel: DetailedWeatherModel){
        weatherDao.saveLastWeatherData(detailedWeatherModel)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe()
    }
}