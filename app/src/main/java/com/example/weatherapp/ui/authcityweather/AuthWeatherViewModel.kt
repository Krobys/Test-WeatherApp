package com.example.weatherapp.ui.authcityweather

import android.app.Application
import com.example.weatherapp.WeatherApplication
import com.example.weatherapp.base.BaseViewModel
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class AuthWeatherViewModel @Inject constructor(application: WeatherApplication): BaseViewModel(application) {

    private var listCities: ArrayList<String> = ArrayList()

    fun getCitiesByPrefix(prefix: String): List<String> {
        val citiesByPrefix = ArrayList<String>()

        if (listCities.isEmpty()) {
            val arrayFilteredList = convertFileToList()
            arrayFilteredList?.let {
                listCities = it
            }
        }

        citiesByPrefix.addAll(listCities.filter {
            it.toLowerCase(Locale.getDefault()).startsWith(prefix.toLowerCase(Locale.getDefault()))
        })

        return citiesByPrefix
    }

    private fun convertFileToList(): ArrayList<String>?{
        var reader: BufferedReader? = null
        var list: ArrayList<String>? = null
        try {
            list = ArrayList()
            reader = BufferedReader(
                InputStreamReader(
                    getApplication<Application>().assets.open("cities"),
                    "UTF-8")
            )

            var line: String? = ""
            while (line  != null) {
                line = reader.readLine()
                // add line if it`s not null
                line?.let { list.add(it) }
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close()
                } catch (e: Exception) { e.printStackTrace() }
            }
            return list
        }
    }

}