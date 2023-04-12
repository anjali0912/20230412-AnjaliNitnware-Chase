package com.example.weatherapp.weather

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.core.BaseViewModel
import com.example.domain.model.WeatherModel
import com.example.domain.params.WeatherParams
import com.example.domain.usecase.WeatherUseCase
import com.example.weatherapp.BuildConfig
import kotlinx.coroutines.launch

class MainViewModel(
    application: Application,
    data: MainData,
    private val weatherUseCase: WeatherUseCase
) : BaseViewModel<MainData, MainEvents>(application, data) {

    private var _state = mutableStateOf(MainData())
    val state: State<MainData> = _state

    init {
        getWeather()
    }

    private fun getWeatherParams(cityName: String = ""): WeatherParams {
        val name = cityName.ifEmpty {
            DEFAULT_CITY_NAME
        }
        return WeatherParams(name, BuildConfig.APIKEY)
    }

    private fun setWeatherModel(model: WeatherModel) {
        _state.value = state.value.copy(weatherModel = model)
    }

    private fun setLoadingState(loadingState: Boolean) {
        _state.value = state.value.copy(loadingState = loadingState)
    }

    private fun setErrorState(errorState: Boolean) {
        _state.value = state.value.copy(errorState = errorState)
    }

    fun getWeather(cityName: String = "") {
        setLoadingState(true)
        setErrorState(false)
        viewModelScope.launch {
            weatherUseCase.execute(getWeatherParams(cityName)).mapResult(
                success = { weatherModel ->
                    setWeatherModel(weatherModel)
                    setLoadingState(false)
                    updateEvent(MainEvents.OnSuccess)
                },
                failure = {
                    setLoadingState(false)
                    setErrorState(true)
                    updateEvent(MainEvents.OnFailure)
                }
            )
        }
    }

    companion object {
        const val DEFAULT_CITY_NAME = "pune"
    }
}