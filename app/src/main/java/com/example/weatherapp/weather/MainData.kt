package com.example.weatherapp.weather

import androidx.lifecycle.MutableLiveData
import com.example.core.BaseData

data class MainData(
    val empty: MutableLiveData<String> = MutableLiveData("")
) : BaseData() {

}