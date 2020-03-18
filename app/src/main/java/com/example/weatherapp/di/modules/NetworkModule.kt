package com.example.weatherapp.di.modules

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.network.ApiRetrofitInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideApiRetrofitInterface(retrofit: Retrofit): ApiRetrofitInterface {
        return retrofit.create(ApiRetrofitInterface::class.java)
    }

}