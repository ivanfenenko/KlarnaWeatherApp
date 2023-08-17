package me.ivanfenenko.klarnaweather.ui

import me.ivanfenenko.klarnaweather.model.WeatherDaily
import me.ivanfenenko.klarnaweather.model.WeatherHourly
import me.ivanfenenko.klarnaweather.model.WeatherNow

sealed class MainScreenState {
    data object Loading : MainScreenState()
    data class Forecast(
        val weatherNow: WeatherNow,
        val weatherHourly: List<WeatherHourly>,
        val weatherDaily: List<WeatherDaily>
    ) : MainScreenState()
}