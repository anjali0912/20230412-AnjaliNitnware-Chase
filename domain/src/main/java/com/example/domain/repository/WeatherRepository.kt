package com.example.domain.repository

import com.example.domain.model.WeatherModel
import com.example.core.Result
import com.example.core.Error
import com.example.domain.params.WeatherParams

interface WeatherRepository {
    suspend fun getWeather(
        params: WeatherParams
    ): Result<Error, WeatherModel>
}