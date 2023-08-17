package me.ivanfenenko.klarnaweather.repository

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import me.ivanfenenko.klarnaweather.model.api.ForecastResponseObject
import me.ivanfenenko.klarnaweather.network.WeatherApi
import java.io.IOException
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: WeatherApi
) {

    private val _currentWeatherForecast = MutableSharedFlow<ForecastResponseObject>()
    val currentWeatherForecast: SharedFlow<ForecastResponseObject> = _currentWeatherForecast.asSharedFlow()

    @Throws(IOException::class)
    suspend fun loadWeatherForecastForCity(city: String) {
        val result = api.getWeatherForecastForCity(city)
        _currentWeatherForecast.emit(result)
    }
}