package com.example.weatherapp.di.components

import com.example.weatherapp.di.modules.DatabaseModule
import com.example.weatherapp.WeatherApplication
import com.example.weatherapp.di.modules.AppModule
import com.example.weatherapp.di.modules.NetworkModule
import com.example.weatherapp.di.modules.ViewModelModule
import com.example.weatherapp.di.modules.builders.ActivityBuildersModule
import com.example.weatherapp.di.modules.builders.FragmentsBuilderModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    DatabaseModule::class,
    NetworkModule::class,
    AppModule::class,
    ActivityBuildersModule::class,
    FragmentsBuilderModule::class,
    ViewModelModule::class])
interface AppComponent : AndroidInjector<WeatherApplication>{

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<WeatherApplication>()

}