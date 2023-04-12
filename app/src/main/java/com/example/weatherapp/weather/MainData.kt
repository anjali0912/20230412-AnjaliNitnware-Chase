package com.example.weatherapp.weather

import com.example.core.BaseData
import com.example.domain.model.WeatherModel

data class MainData(
    val weatherModel: WeatherModel = WeatherModel(),
    val loadingState: Boolean = false,
    val errorState: Boolean = false,
) : BaseData()