package com.example.data.remotesource

import com.example.core.ResponseMapper
import com.example.domain.model.WeatherModel
import com.example.core.Result
import com.example.core.Error
import com.example.domain.params.WeatherParams

interface WeatherRemoteSource : ResponseMapper {
    suspend fun getWeather(
        parameter: WeatherParams
    ): Result<Error, WeatherModel>
}