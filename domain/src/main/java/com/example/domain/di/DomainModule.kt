package com.example.domain.di

import com.example.domain.usecase.WeatherUseCase
import com.example.domain.usecase.WeatherUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<WeatherUseCase> { WeatherUseCaseImpl(repository = get()) }
}