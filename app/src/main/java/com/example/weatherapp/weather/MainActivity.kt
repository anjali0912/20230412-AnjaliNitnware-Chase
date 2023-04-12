package com.example.weatherapp.weather

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.core.BaseActivity
import com.example.core.BaseEvent
import com.example.weatherapp.R

class MainActivity : BaseActivity<MainEvents, MainData, MainViewModel>(
    MainViewModel::class,
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val cityName: (String) -> Unit = { cityName ->
                viewModel.getWeather(cityName)
            }
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.weather),
                    contentDescription = "",
                    contentScale = ContentScale.FillHeight
                )
                MainView(viewModel, cityName)
            }
        }
    }

    override fun eventUpdated(event: BaseEvent) {
        when (event) {
            is MainEvents.OnSuccess -> {
            }
            is MainEvents.OnFailure -> {
            }
        }
    }
}