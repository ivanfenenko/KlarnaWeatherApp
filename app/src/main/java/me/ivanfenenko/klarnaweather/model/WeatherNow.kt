package me.ivanfenenko.klarnaweather.model

data class WeatherNow(
    val cityTitle: String,
    val currentTemperature: String,
    val animation: Animation,
    val sunrise: String,
    val sunset: String
)