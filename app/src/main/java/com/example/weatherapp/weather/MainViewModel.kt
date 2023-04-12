package com.example.weatherapp.weather

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.core.BaseViewModel
import com.example.domain.params.WeatherParams
import com.example.domain.usecase.WeatherUseCase
import com.example.weatherapp.BuildConfig
import kotlinx.coroutines.launch

class MainViewModel(
    data: MainData,
    application: Application,
    private val weatherUseCase: WeatherUseCase
) : BaseViewModel<MainData>(application, data) {

    private var _state = mutableStateOf(MainData())
    val state: State<MainData> = _state

    init {
        getWeather()
    }

    private fun getWeatherParams() = WeatherParams(DEFAULT_CITY_NAME, BuildConfig.APIKEY)

    private fun getWeather() {
        viewModelScope.launch {
            weatherUseCase.execute(getWeatherParams()).mapResult(
                success = { weatherModel ->
                },
                failure = { error ->
                }
            )
        }
    }

    companion object {
        const val DEFAULT_CITY_NAME = "pune"
    }
}