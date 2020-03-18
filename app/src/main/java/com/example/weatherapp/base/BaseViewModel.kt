package com.example.weatherapp.base

import androidx.lifecycle.AndroidViewModel
import com.example.weatherapp.WeatherApplication
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel(application: WeatherApplication) : AndroidViewModel(application) {
    protected val disposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}