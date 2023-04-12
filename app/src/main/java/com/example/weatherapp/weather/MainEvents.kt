package com.example.weatherapp.weather

import com.example.core.BaseEvent

sealed class MainEvents : BaseEvent {
    object OnSuccess : MainEvents()
    object OnFailure : MainEvents()
}