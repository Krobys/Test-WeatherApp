package com.example.weatherapp.ui.detailscityweather


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.weatherapp.MainActivity
import com.example.weatherapp.MainActivity.Companion.CITY_NAME
import com.example.weatherapp.R
import com.example.weatherapp.base.BaseFragment
import com.example.weatherapp.databinding.FragmentDetailedCityWeatherBinding
import com.example.weatherapp.utils.SharedPreferenceUtils


class DetailedCityWeatherFragment(
    override val viewModelClass: Class<DetailedWeatherViewModel> = DetailedWeatherViewModel::class.java,
    override val layoutId: Int = R.layout.fragment_detailed_city_weather
) : BaseFragment<DetailedWeatherViewModel, FragmentDetailedCityWeatherBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCityName()?.let { cityName ->
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getWeatherForCity(cityName)
                .observe(this, Observer {
                    if (it != null){ binding.weatherModel = it }
                    else{ (activity as? MainActivity)?.chooseCityFragment() }
                    binding.progressBar.visibility = View.INVISIBLE
                })
        }
        binding.editCity.setOnClickListener{
            (activity as? MainActivity)?.chooseCityFragment()
        }
    }

    private fun getCityName() : String?{
         arguments?.let { argument ->
             return argument.getString(CITY_NAME)?.let { cityName ->
                 SharedPreferenceUtils.setSavedCity(context, cityName)
                 cityName
            }
        } ?: SharedPreferenceUtils.getSavedCityName(context)
        return null
    }
}
