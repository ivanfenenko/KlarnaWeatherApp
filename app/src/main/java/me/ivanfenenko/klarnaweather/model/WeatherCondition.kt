package me.ivanfenenko.klarnaweather.model

enum class WeatherCondition(
    val key: String
) {
    CLEAR_DAY("ic_clear_day"),
    IC_CLEAR_NIGHT("ic_clear_night"),
    IC_CLOUDY("ic_cloudy"),
    IC_FOG("ic_fog"),
    IC_HAIL("ic_hail"),
    IC_PARTLY_CLOUDY_DAY("ic_partly_cloudy_day"),
    IC_PARTLY_CLOUDY_NIGHT("ic_partly_cloudy_night"),
    IC_RAIN("ic_rain"),
    IC_RAIN_SNOW("ic_rain_snow"),
    IC_RAIN_SNOW_SHOWERS_DAY("ic_rain_snow_showers_day"),
    IC_RAIN_SNOW_SHOWERS_NIGHT("ic_rain_snow_showers_night"),
    IC_SHOWERS_DAY("ic_showers_day"),
    IC_SHOWERS_NIGHT("ic_showers_night"),
    IC_SLEET("ic_sleet"),
    IC_SNOW("ic_snow"),
    IC_SNOW_SHOWERS_DAY("ic_snow_showers_day"),
    IC_SNOW_SHOWERS_NIGHT("ic_snow_showers_night"),
    IC_THUNDER("ic_thunder"),
    IC_THUNDER_RAIN("ic_thunder_rain"),
    IC_THUNDER_SHOWERS_DAY("ic_thunder_showers_day"),
    IC_THUNDER_SHOWERS_NIGHT("ic_thunder_showers_night"),
    IC_WIND("ic_wind");
}