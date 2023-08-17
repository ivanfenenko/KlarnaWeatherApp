package me.ivanfenenko.klarnaweather.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.ivanfenenko.klarnaweather.ui.widgets.WeatherTodayHourlyWidget
import me.ivanfenenko.klarnaweather.ui.widgets.WeatherTodayWidget
import me.ivanfenenko.klarnaweather.ui.widgets.WeatherWeekForecastWidget

@Composable
fun MainScreen(viewModel: MainScreenViewModel) {
    Column(
        Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center
    ) {
        val state = viewModel.weatherState.collectAsState()
        when (val value = state.value) {
            MainScreenState.Loading -> {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                )
            }
            is MainScreenState.Forecast -> {
                WeatherTodayWidget(value.weatherNow)
                Spacer(modifier = Modifier.height(50.dp))
                WeatherTodayHourlyWidget(value.weatherHourly)
                WeatherWeekForecastWidget(value.weatherDaily)
            }
        }
    }
}