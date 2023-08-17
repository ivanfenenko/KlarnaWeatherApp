package me.ivanfenenko.klarnaweather.ui.model

import me.ivanfenenko.klarnaweather.model.api.ForecastResponseObject
import me.ivanfenenko.klarnaweather.ui.screens.main.MainScreenState
import java.text.SimpleDateFormat


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

private fun String.toWeatherCondition(): WeatherCondition {
    return WeatherCondition.fromKey(this)
}

private fun WeatherCondition.toAnimation(): Animation {
    return Animation.fromWeatherCondition(this)
}

private fun WeatherCondition.toIcon(): Icon {
    return Icon.fromKey(this)
}

private fun String.toHour(): String {
    hoursMinutesSecondsFormat.parse(this)?.let { date ->
        return hoursMinutesFormat.format(date)
    }
    return ""
}

private fun String.toWeekday(): String {
    yearMonthDayFormat.parse(this)?.let { date ->
        return weekdayFormat.format(date)
    }
    return ""
}

private val hoursMinutesFormat = SimpleDateFormat("HH:mm")

private val hoursMinutesSecondsFormat = SimpleDateFormat("HH:mm:ss")

private val yearMonthDayFormat = SimpleDateFormat("yyyy-MM-dd")

private val weekdayFormat = SimpleDateFormat("EEE")