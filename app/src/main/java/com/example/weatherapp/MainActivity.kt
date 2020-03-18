package com.example.weatherapp

import android.os.Bundle
import android.text.TextUtils
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.weatherapp.base.BaseActivity
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.utils.SharedPreferenceUtils

class MainActivity(override val layoutId: Int = R.layout.activity_main) : BaseActivity<ActivityMainBinding>() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController(R.id.nav_host_fragment)
        val savedCityName = SharedPreferenceUtils.getSavedCityName(this)
        if (savedCityName != null && !TextUtils.isEmpty(savedCityName)){
            detailsWeatherInfo(savedCityName)
        }
    }

    fun chooseCityFragment(){
        navController.navigate(R.id.authCity)
    }

    fun detailsWeatherInfo(cityName: String){
        val bundle: Bundle? = Bundle()
        bundle?.putString(CITY_NAME, cityName)
        navController.navigate(R.id.detailedCity, bundle)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    companion object{
        const val CITY_NAME: String = "CITY_NAME"
    }
}
