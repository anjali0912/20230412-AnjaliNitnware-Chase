package com.example.domain.usecase

import com.example.core.BaseUseCase
import com.example.domain.model.WeatherModel
import com.example.domain.params.WeatherParams

interface WeatherUseCase : BaseUseCase<WeatherParams, WeatherModel>