package me.ivanfenenko.klarnaweather.ui.model

import me.ivanfenenko.klarnaweather.R

enum class Icon(val key: WeatherCondition, val value: Int) {
    CLEAR_DAY(WeatherCondition.CLEAR_DAY, R.drawable.ic_clear_day),
    IC_CLEAR_NIGHT(WeatherCondition.IC_CLEAR_NIGHT, R.drawable.ic_clear_night),
    IC_CLOUDY(WeatherCondition.IC_CLOUDY, R.drawable.ic_cloudy),
    IC_FOG(WeatherCondition.IC_FOG, R.drawable.ic_fog),
    IC_HAIL(WeatherCondition.IC_HAIL, R.drawable.ic_hail),
    IC_PARTLY_CLOUDY_DAY(WeatherCondition.IC_PARTLY_CLOUDY_DAY, R.drawable.ic_partly_cloudy_day),
    IC_PARTLY_CLOUDY_NIGHT(WeatherCondition.IC_PARTLY_CLOUDY_NIGHT, R.drawable.ic_partly_cloudy_night),
    IC_RAIN(WeatherCondition.IC_RAIN, R.drawable.ic_rain),
    IC_RAIN_SNOW(WeatherCondition.IC_RAIN_SNOW, R.drawable.ic_rain_snow),
    IC_RAIN_SNOW_SHOWERS_DAY(WeatherCondition.IC_RAIN_SNOW_SHOWERS_DAY, R.drawable.ic_rain_snow_showers_day),
    IC_RAIN_SNOW_SHOWERS_NIGHT(WeatherCondition.IC_RAIN_SNOW_SHOWERS_NIGHT, R.drawable.ic_rain_snow_showers_night),
    IC_SHOWERS_DAY(WeatherCondition.IC_SHOWERS_DAY, R.drawable.ic_showers_day),
    IC_SHOWERS_NIGHT(WeatherCondition.IC_SHOWERS_NIGHT, R.drawable.ic_showers_night),
    IC_SLEET(WeatherCondition.IC_SLEET, R.drawable.ic_sleet),
    IC_SNOW(WeatherCondition.IC_SNOW, R.drawable.ic_snow),
    IC_SNOW_SHOWERS_DAY(WeatherCondition.IC_SNOW_SHOWERS_DAY, R.drawable.ic_snow_showers_day),
    IC_SNOW_SHOWERS_NIGHT(WeatherCondition.IC_SNOW_SHOWERS_NIGHT, R.drawable.ic_snow_showers_night),
    IC_THUNDER(WeatherCondition.IC_THUNDER, R.drawable.ic_thunder),
    IC_THUNDER_RAIN(WeatherCondition.IC_THUNDER_RAIN, R.drawable.ic_thunder_rain),
    IC_THUNDER_SHOWERS_DAY(WeatherCondition.IC_THUNDER_SHOWERS_DAY, R.drawable.ic_thunder_showers_day),
    IC_THUNDER_SHOWERS_NIGHT(WeatherCondition.IC_THUNDER_SHOWERS_NIGHT, R.drawable.ic_thunder_showers_night),
    IC_WIND(WeatherCondition.IC_WIND, R.drawable.ic_wind);

    companion object {
        fun fromKey(key: WeatherCondition) = Icon.values().first { it.key == key }
    }
}