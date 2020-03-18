package com.example.weatherapp.ui.authcityweather


import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.weatherapp.MainActivity
import com.example.weatherapp.R
import com.example.weatherapp.base.BaseFragment
import com.example.weatherapp.databinding.FragmentAuthCityWeatherBinding
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class AuthCityWeatherFragment(
    override val viewModelClass: Class<AuthWeatherViewModel> = AuthWeatherViewModel::class.java,
    override val layoutId: Int = R.layout.fragment_auth_city_weather
) : BaseFragment<AuthWeatherViewModel, FragmentAuthCityWeatherBinding>() {

    private lateinit var disposable: Disposable
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        disposable = RxTextView.textChangeEvents(binding.cityPicker)
            .skip(1)
            .debounce(400, TimeUnit.MILLISECONDS)
            .map{it.text().toString();}
            .filter{it.length > 1}
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{city ->
                val cities = viewModel.getCitiesByPrefix(city)
                context?.let {
                    val adapter = ArrayAdapter<String>(it, android.R.layout.select_dialog_item)
                    adapter.addAll(cities)
                    binding.cityPicker.setAdapter(adapter)
                    adapter.notifyDataSetChanged()
                }
            }
        binding.buttonSubmitPick.setOnClickListener {
            (activity as? MainActivity)?.detailsWeatherInfo(binding.cityPicker.text.toString().trimEnd())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable.dispose()
    }
}
