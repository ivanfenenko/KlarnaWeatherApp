package me.ivanfenenko.klarnaweather.ui.model

enum class WeatherCondition(
    val key: String
) {
    CLEAR_DAY("clear-day"),
    IC_CLEAR_NIGHT("clear-night"),
    IC_CLOUDY("cloudy"),
    IC_FOG("fog"),
    IC_HAIL("hail"),
    IC_PARTLY_CLOUDY_DAY("partly-cloudy-day"),
    IC_PARTLY_CLOUDY_NIGHT("partly-cloudy-night"),
    IC_RAIN("rain"),
    IC_RAIN_SNOW("rain-snow"),
    IC_RAIN_SNOW_SHOWERS_DAY("rain-snow-showers-day"),
    IC_RAIN_SNOW_SHOWERS_NIGHT("rain-snow-showers-night"),
    IC_SHOWERS_DAY("showers-day"),
    IC_SHOWERS_NIGHT("showers-night"),
    IC_SLEET("sleet"),
    IC_SNOW("snow"),
    IC_SNOW_SHOWERS_DAY("snow-showers-day"),
    IC_SNOW_SHOWERS_NIGHT("snow-showers-night"),
    IC_THUNDER("thunder"),
    IC_THUNDER_RAIN("thunder-rain"),
    IC_THUNDER_SHOWERS_DAY("thunder-showers-day"),
    IC_THUNDER_SHOWERS_NIGHT("thunder-shower-night"),
    IC_WIND("wind");

    companion object {
        fun fromKey(key: String) = WeatherCondition.values().first { it.key == key }
    }
}