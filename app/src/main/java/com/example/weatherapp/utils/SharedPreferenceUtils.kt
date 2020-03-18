package com.example.weatherapp.utils

import android.content.Context
import androidx.preference.PreferenceManager

object SharedPreferenceUtils{

    fun setSavedCity(context: Context?, cityName: String) {
        PreferenceManager.getDefaultSharedPreferences(context).edit()
            .putString(SAVED_CITY_NAME, cityName)
            .apply()
    }

    fun getSavedCityName(context: Context?): String?{
        return PreferenceManager.getDefaultSharedPreferences(context)
            .getString(SAVED_CITY_NAME, "")
    }
    const val SAVED_CITY_NAME = "SAVED_CITY_NAME"
}