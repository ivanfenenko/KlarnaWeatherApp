package me.ivanfenenko.klarnaweather.ui.screens.main

import me.ivanfenenko.klarnaweather.ui.model.WeatherDaily
import me.ivanfenenko.klarnaweather.ui.model.WeatherHourly
import me.ivanfenenko.klarnaweather.ui.model.WeatherNow

sealed class MainScreenState {
    data object Loading : MainScreenState()
    data class Forecast(
        val weatherNow: WeatherNow,
        val weatherHourly: List<WeatherHourly>,
        val weatherDaily: List<WeatherDaily>
    ) : MainScreenState()
}