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
import me.ivanfenenko.klarnaweather.ui.model.Animation
import me.ivanfenenko.klarnaweather.ui.model.Icon
import me.ivanfenenko.klarnaweather.ui.model.WeatherCondition
import me.ivanfenenko.klarnaweather.ui.model.WeatherDaily
import me.ivanfenenko.klarnaweather.ui.model.WeatherHourly
import me.ivanfenenko.klarnaweather.ui.model.WeatherNow
import me.ivanfenenko.klarnaweather.model.api.ForecastResponseObject
import me.ivanfenenko.klarnaweather.repository.WeatherRepository
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _refreshState = MutableStateFlow(false)
    val refreshState: StateFlow<Boolean> = _refreshState.asStateFlow()

    val weatherState: StateFlow<MainScreenState> = weatherRepository
        .currentWeatherForecast.map { forecastResponseObject ->
            forecastResponseObject.toState()
        }.stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            MainScreenState.Loading
        )

    init {
        viewModelScope.launch {
            weatherRepository.loadWeatherForecastForCity("Berlin")
        }
    }

    fun refresh(city: String) {
        viewModelScope.launch {
            viewModelScope.launch {
                weatherRepository.loadWeatherForecastForCity(city)
            }
        }
    }
    fun changeCity(city: String) {
        viewModelScope.launch {
            weatherRepository.loadWeatherForecastForCity(city)
        }
    }
}

fun ForecastResponseObject.toState(): MainScreenState.Forecast {
    return MainScreenState.Forecast(
        weatherNow = WeatherNow(
            this.address,
            this.currentConditions.temp.toInt().toString(),
            this.currentConditions.icon.toWeatherCondition().toAnimation(),
            this.currentConditions.sunrise.toHour(),
            this.currentConditions.sunset.toHour()
        ),
        weatherHourly = this.days[0].hours.map { hour ->
            WeatherHourly(
                hour.datetime.toHour(),
                hour.temp.toInt().toString(),
                hour.icon.toWeatherCondition().toIcon()
            )
        },
        weatherDaily = this.days.map { day ->
            WeatherDaily(
                day.datetime.toWeekday(),
                day.temp.toInt().toString(),
                day.icon.toWeatherCondition().toIcon()
            )
        }
    )
}

fun String.toWeatherCondition(): WeatherCondition {
    return WeatherCondition.fromKey(this)
}

fun WeatherCondition.toAnimation(): Animation {
    return Animation.fromWeatherCondition(this)
}

fun WeatherCondition.toIcon(): Icon {
    return me.ivanfenenko.klarnaweather.ui.model.Icon.fromKey(this)
}

fun String.toHour(): String {
    hoursMinutesSecondsFormat.parse(this)?.let { date ->
        return hoursMinutesFormat.format(date)
    }
    return ""
}

fun String.toWeekday(): String {
    yearMonthDayFormat.parse(this)?.let { date ->
        return weekdayFormat.format(date)
    }
    return ""
}

private val hoursMinutesFormat = SimpleDateFormat("HH:mm")

private val hoursMinutesSecondsFormat = SimpleDateFormat("HH:mm:ss")

private val yearMonthDayFormat = SimpleDateFormat("yyyy-MM-dd")

private val weekdayFormat = SimpleDateFormat("EEE")