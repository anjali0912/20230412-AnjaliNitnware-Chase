package com.example.weatherapp.weather

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.BaseActivity
import com.example.domain.model.WeatherItem
import com.example.domain.model.WeatherModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel, MainData>(MainViewModel::class) {

    override val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            WeatherView()
        }
    }
}

@Preview
@Composable
fun WeatherView() {
    Column(modifier = Modifier.fillMaxSize()) {
        SearchView()
        WeatherMainView()
    }
}

@Composable
fun SearchView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(all = 8.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "hi",
            onValueChange = {
//                text = it
            },
            label = {
                Text("Search")
            },
            placeholder = {
                Text("Placeholder")
            }
        )
    }
}

@Composable
fun WeatherMainView() {
    val model = WeatherModel(
        base = "base",
        latitude = "1.0",
        longitude = "2.0",
        feelsLike = "3.0",
        grandLevel = "4",
        humidity = "5",
        pressure = "6",
        seaLevel = "7",
        temp = "8.0",
        tempMax = "9.0",
        tempMin = "10.0",
        name = "name",
        country = "country",
        sunset = "11",
        sunrise = "12",
        type = "13",
        timezone = "14",
        visibility = "15",
        deg = "16",
        gust = "17.0",
        speed = "18.0",
        weather = listOf(
            WeatherItem(
                description = "description1",
                icon = "icon1",
                main = "main1"
            ),
            WeatherItem(
                description = "description2",
                icon = "icon2",
                main = "main2"
            ),
            WeatherItem(
                description = "description3",
                icon = "icon3",
                main = "main3"
            ),
        )

    )
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(all = 8.dp)
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(all = 5.dp)
        ) {
            Column(modifier = Modifier.padding(5.dp)) {
                WeatherContents("Base", model.base)
                WeatherContents("Latitude", model.latitude.toString())
                WeatherContents("Longitude", model.longitude.toString())
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(all = 5.dp)
        ) {
            Column(modifier = Modifier.padding(5.dp)) {
                WeatherContents("Feels Like", model.feelsLike.toString())
                WeatherContents("Grand Level", model.grandLevel.toString())
                WeatherContents("Humidity", model.humidity.toString())
                WeatherContents("Pressure", model.pressure.toString())
                WeatherContents("Sea Level", model.seaLevel.toString())
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(all = 5.dp)
        ) {
            Column(modifier = Modifier.padding(5.dp)) {
                WeatherContents("Temperature", model.temp.toString())
                WeatherContents("Minimum Temperature", model.tempMin.toString())
                WeatherContents("Maximum Temperature", model.tempMax.toString())
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(all = 5.dp)
        ) {
            Column(modifier = Modifier.padding(5.dp)) {
                WeatherContents("Name", model.name)
                WeatherContents("Country", model.country)
                WeatherContents("Sunset", model.sunset.toString())
                WeatherContents("Sunrise", model.sunrise.toString())
                WeatherContents("Type", model.type.toString())
                WeatherContents("Timezone", model.timezone.toString())
                WeatherContents("Visibility", model.visibility.toString())
                WeatherContents("Degree", model.deg.toString())
                WeatherContents("Speed", model.speed.toString())
                WeatherContents("Gust", model.gust.toString())
            }
        }

        for (weatherItem in model.weather) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = 5.dp)
            ) {
                Column(modifier = Modifier.padding(5.dp)) {
                    WeatherContents("Weather Description", weatherItem.description)
                    WeatherContents("Weather Icon", weatherItem.icon)
                    WeatherContents("Weather Main", weatherItem.main)
                }
            }
        }
    }
}

@Composable
fun WeatherContents(label: String, value: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(all = 5.dp),
        text = label,
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(all = 5.dp),
        text = value,
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Light
    )
}
//data class WeatherModel(
//    val base: String,
//    val latitude: Double,
//    val longitude: Double,
//    val feelsLike: Double,
//    val grandLevel: Int,
//    val humidity: Int,
//    val pressure: Int,
//    val seaLevel: Int,
//    val temp: Double,
//    val tempMax: Double,
//    val tempMin: Double,
//    val name: String,
//    val country: String,
//    val sunrise: Int,
//    val sunset: Int,
//    val type: Int,
//    val timezone: Int,
//    val visibility: Int,
//    val weather: List<WeatherItem>,
//    val deg: Int,
//    val gust: Double,
//    val speed: Double
//)
//
//data class WeatherItem(
//    val description: String,
//    val icon: String,
//    val main: String
//)