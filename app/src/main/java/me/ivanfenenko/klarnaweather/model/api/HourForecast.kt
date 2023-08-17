package me.ivanfenenko.klarnaweather.model.api

import com.google.gson.annotations.SerializedName

data class HourForecast(
    @SerializedName("datetime") var datetime: String,
    @SerializedName("temp") var temp: Double,
    @SerializedName("icon") var icon: String,
)