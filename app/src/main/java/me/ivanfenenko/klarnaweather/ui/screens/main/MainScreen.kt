package me.ivanfenenko.klarnaweather.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.ivanfenenko.klarnaweather.ui.widgets.TopBarWidget
import me.ivanfenenko.klarnaweather.ui.widgets.WeatherTodayHourlyWidget
import me.ivanfenenko.klarnaweather.ui.widgets.WeatherTodayWidget
import me.ivanfenenko.klarnaweather.ui.widgets.WeatherWeekForecastWidget

@Composable
fun MainScreen(viewModel: MainScreenViewModel) {
    TopBarWidget { city ->
        viewModel.loadCity(city)
    }
    Column(
        Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center
    ) {
        val forecastState = viewModel.weatherState.collectAsState()
        val loadingState = viewModel.loadingState.collectAsState()

        when (val loadingStateValue = loadingState.value) {
            is ForecastLoadingState.Error -> {
                Column {
                    Text(text = loadingStateValue.errorText)
                    TextButton(onClick = { viewModel.loadCity() }) {
                        Text("Retry")
                    }
                }
            }

            ForecastLoadingState.Loading -> {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                )
            }

            ForecastLoadingState.Ready -> {
                when (val forecastStateValue = forecastState.value) {
                    MainScreenState.NotAvailable -> {
                    }

                    is MainScreenState.Forecast -> {
                        WeatherTodayWidget(forecastStateValue.weatherNow)
                        Spacer(modifier = Modifier.height(50.dp))
                        WeatherTodayHourlyWidget(forecastStateValue.weatherHourly)
                        WeatherWeekForecastWidget(forecastStateValue.weatherDaily)
                    }
                }
            }
        }
    }
}