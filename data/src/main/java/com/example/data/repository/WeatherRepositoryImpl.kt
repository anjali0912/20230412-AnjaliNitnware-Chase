package com.example.data.repository

import com.example.data.remotesource.WeatherRemoteSource
import com.example.domain.model.WeatherModel
import com.example.domain.repository.WeatherRepository
import com.example.core.Error
import com.example.core.Result
import com.example.domain.params.WeatherParams

class WeatherRepositoryImpl(private val source: WeatherRemoteSource) :
    WeatherRepository {

    override suspend fun getWeather(
        params: WeatherParams
    ): Result<Error, WeatherModel> = source.getWeather(
        parameter = params
    )
}