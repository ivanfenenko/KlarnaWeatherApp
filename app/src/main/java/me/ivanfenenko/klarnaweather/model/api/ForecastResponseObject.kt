package me.ivanfenenko.klarnaweather.model.api

import com.google.gson.annotations.SerializedName

data class ForecastResponseObject(
    @SerializedName("queryCost") val queryCost: Int? = null,
    @SerializedName("latitude") val latitude: Double? = null,
    @SerializedName("longitude") val longitude: Double? = null,
    @SerializedName("resolvedAddress") val resolvedAddress: String? = null,
    @SerializedName("address") val address: String,
    @SerializedName("timezone") val timezone: String? = null,
    @SerializedName("tzoffset") val tzoffset: Int? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("days") val days: ArrayList<DayForecast> = arrayListOf(),
    @SerializedName("alerts") val alerts: ArrayList<String> = arrayListOf(),
    @SerializedName("currentConditions") val currentConditions: CurrentConditions
)