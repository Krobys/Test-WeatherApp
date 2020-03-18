package com.example.weatherapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akrivonos.a2chparser.dagger.modules.ViewModelKey
import com.example.weatherapp.ui.authcityweather.AuthWeatherViewModel
import com.example.weatherapp.ui.detailscityweather.DetailedWeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(AuthWeatherViewModel::class)
    abstract fun bindBoardsViewModel(authWeatherViewModel: AuthWeatherViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailedWeatherViewModel::class)
    abstract fun bindConcreteBoardViewModel(detailedWeatherViewModel: DetailedWeatherViewModel): ViewModel

}
