package com.example.weatherapp

import com.example.weatherapp.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerApplication

class WeatherApplication : DaggerApplication(), HasAndroidInjector{

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.builder().create(this)

}