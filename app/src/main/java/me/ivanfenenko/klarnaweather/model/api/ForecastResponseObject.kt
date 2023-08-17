package me.ivanfenenko.klarnaweather.model.api

import com.google.gson.annotations.SerializedName

data class ForecastResponseObject(
    @SerializedName("address") val address: String,
    @SerializedName("days") val days: ArrayList<DayForecast> = arrayListOf(),
    @SerializedName("currentConditions") val currentConditions: CurrentConditions
)