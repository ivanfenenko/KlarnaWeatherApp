package me.ivanfenenko.klarnaweather.model

import me.ivanfenenko.klarnaweather.R

enum class Animation(val value: Int) {

    ANIM_CLEAR_NIGHT(R.raw.anim_clear_night),
    ANIM_CLOUDY(R.raw.anim_cloudy),
    ANIM_CLOUDY_NIGHT(R.raw.anim_cloudy_night),
    ANIM_CLOUDY_PARTIALLY(R.raw.anim_cloudy_partially),
    ANIM_FOG(R.raw.anim_fog),
    ANIM_RAINY_NIGHT(R.raw.anim_rainy_night),
    ANIM_SNOW(R.raw.anim_snow),
    ANIM_SNOWY_NIGHT(R.raw.anim_snowy_night),
    ANIM_CLEAR_DAY(R.raw.anim_sunny),
    ANIM_SUNNY_RAIN(R.raw.anim_sunny_rain),
    ANIM_SUNNY_SNOW(R.raw.anim_sunny_snow),
    ANIM_THUNDER(R.raw.anim_thunder),
    ANIM_THUNDER_STORM(R.raw.anim_thunder_storm),
    ANIM_THUNDER_SUNNY(R.raw.anim_thunder_sunny);

    companion object {
        fun fromWeatherCondition(key: WeatherCondition): Animation {
            return when (key) {
                WeatherCondition.CLEAR_DAY -> ANIM_CLEAR_DAY
                WeatherCondition.IC_CLEAR_NIGHT -> ANIM_CLEAR_NIGHT
                WeatherCondition.IC_CLOUDY -> ANIM_CLOUDY
                WeatherCondition.IC_FOG -> ANIM_FOG
                WeatherCondition.IC_HAIL -> ANIM_THUNDER_STORM
                WeatherCondition.IC_PARTLY_CLOUDY_DAY -> ANIM_CLOUDY_PARTIALLY
                WeatherCondition.IC_PARTLY_CLOUDY_NIGHT -> ANIM_CLOUDY_NIGHT
                WeatherCondition.IC_RAIN -> ANIM_SUNNY_RAIN
                WeatherCondition.IC_RAIN_SNOW -> ANIM_SNOW
                WeatherCondition.IC_RAIN_SNOW_SHOWERS_DAY -> ANIM_SUNNY_SNOW
                WeatherCondition.IC_RAIN_SNOW_SHOWERS_NIGHT -> ANIM_SNOWY_NIGHT
                WeatherCondition.IC_SHOWERS_DAY -> ANIM_SUNNY_RAIN
                WeatherCondition.IC_SHOWERS_NIGHT -> ANIM_RAINY_NIGHT
                WeatherCondition.IC_SLEET -> ANIM_SNOW
                WeatherCondition.IC_SNOW -> ANIM_SNOW
                WeatherCondition.IC_SNOW_SHOWERS_DAY -> ANIM_SNOW
                WeatherCondition.IC_SNOW_SHOWERS_NIGHT -> ANIM_SNOWY_NIGHT
                WeatherCondition.IC_THUNDER -> ANIM_THUNDER
                WeatherCondition.IC_THUNDER_RAIN -> ANIM_THUNDER
                WeatherCondition.IC_THUNDER_SHOWERS_DAY -> ANIM_THUNDER_SUNNY
                WeatherCondition.IC_THUNDER_SHOWERS_NIGHT -> ANIM_RAINY_NIGHT
                WeatherCondition.IC_WIND -> ANIM_CLEAR_DAY
            }
        }
    }
}