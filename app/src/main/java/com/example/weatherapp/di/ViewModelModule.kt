package com.example.weatherapp.di

import com.example.weatherapp.weather.MainData
import com.example.weatherapp.weather.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val presentationModule = module {

    viewModel {
        MainViewModel(
            data = MainData(),
            application = androidApplication(),
            weatherUseCase = get()
        )
    }
}