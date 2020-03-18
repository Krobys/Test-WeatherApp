package com.example.weatherapp.di.modules.builders

import com.example.weatherapp.ui.authcityweather.AuthCityWeatherFragment
import com.example.weatherapp.ui.detailscityweather.DetailedCityWeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector
    abstract fun bindAuthWeatherFragment(): AuthCityWeatherFragment

    @ContributesAndroidInjector
    abstract fun bindDetailedWeatherFragment(): DetailedCityWeatherFragment

}