package me.ivanfenenko.klarnaweather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import me.ivanfenenko.klarnaweather.model.Animation
import me.ivanfenenko.klarnaweather.model.Icon
import me.ivanfenenko.klarnaweather.model.WeatherCondition
import me.ivanfenenko.klarnaweather.model.WeatherDaily
import me.ivanfenenko.klarnaweather.model.WeatherHourly
import me.ivanfenenko.klarnaweather.model.WeatherNow
import me.ivanfenenko.klarnaweather.model.api.ForecastResponseObject
import me.ivanfenenko.klarnaweather.repository.WeatherRepository
import me.ivanfenenko.klarnaweather.ui.MainScreenState
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    val uiState: StateFlow<MainScreenState> = weatherRepository
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
    return Icon.fromKey(this)
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