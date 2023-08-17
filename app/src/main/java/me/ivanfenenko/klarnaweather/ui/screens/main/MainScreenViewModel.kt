package me.ivanfenenko.klarnaweather.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import me.ivanfenenko.klarnaweather.model.api.ForecastResponseObject
import me.ivanfenenko.klarnaweather.repository.WeatherRepository
import me.ivanfenenko.klarnaweather.ui.model.Animation
import me.ivanfenenko.klarnaweather.ui.model.Icon
import me.ivanfenenko.klarnaweather.ui.model.WeatherCondition
import me.ivanfenenko.klarnaweather.ui.model.WeatherDaily
import me.ivanfenenko.klarnaweather.ui.model.WeatherHourly
import me.ivanfenenko.klarnaweather.ui.model.WeatherNow
import me.ivanfenenko.klarnaweather.ui.model.toState
import java.io.IOException
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _loadingState = MutableStateFlow<ForecastLoadingState>(ForecastLoadingState.Loading)
    val loadingState: StateFlow<ForecastLoadingState> = _loadingState.asStateFlow()

    val weatherState: StateFlow<MainScreenState> = weatherRepository
        .currentWeatherForecast.map { forecastResponseObject ->
            forecastResponseObject.toState()
        }.stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            MainScreenState.NotAvailable
        )

    init {
        loadCity()
    }

    fun loadCity(city: String = "Berlin") {
        viewModelScope.launch {
            try {
                _loadingState.emit(ForecastLoadingState.Loading)
                weatherRepository.loadWeatherForecastForCity(city)
                _loadingState.emit(ForecastLoadingState.Ready)
            } catch (io: IOException) {
                _loadingState.emit(ForecastLoadingState.Error(io.message.toString()))
            }
        }
    }
}
