package me.ivanfenenko.klarnaweather.model.api

import com.google.gson.annotations.SerializedName

data class CurrentConditions(
    @SerializedName("temp") val temp: Double,
    @SerializedName("icon") val icon: String,
    @SerializedName("sunrise") val sunrise: String,
    @SerializedName("sunset") val sunset: String,
)