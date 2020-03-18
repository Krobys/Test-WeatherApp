package com.example.weatherapp.di.modules.builders

import android.app.Application
import com.example.weatherapp.MainActivity
import com.example.weatherapp.WeatherApplication
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @Binds
    abstract fun bindWeatherApplication(app: WeatherApplication): Application

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}