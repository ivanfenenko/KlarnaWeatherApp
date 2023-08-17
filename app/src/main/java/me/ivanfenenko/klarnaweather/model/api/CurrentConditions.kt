package me.ivanfenenko.klarnaweather.model.api

import com.google.gson.annotations.SerializedName

data class CurrentConditions(
    @SerializedName("datetime") val datetime: String? = null,
    @SerializedName("datetimeEpoch") val datetimeEpoch: Int? = null,
    @SerializedName("temp") val temp: Double,
    @SerializedName("feelslike") val feelslike: Double? = null,
    @SerializedName("humidity") val humidity: Double? = null,
    @SerializedName("dew") val dew: Double? = null,
    @SerializedName("precip") val precip: Int? = null,
    @SerializedName("precipprob") val precipprob: Int? = null,
    @SerializedName("snow") val snow: Int? = null,
    @SerializedName("snowdepth") val snowdepth: Int? = null,
    @SerializedName("preciptype") val preciptype: String? = null,
    @SerializedName("windgust") val windgust: Double? = null,
    @SerializedName("windspeed") val windspeed: Double? = null,
    @SerializedName("winddir") val winddir: Int? = null,
    @SerializedName("pressure") val pressure: Int? = null,
    @SerializedName("visibility") val visibility: Int? = null,
    @SerializedName("cloudcover") val cloudcover: Int? = null,
    @SerializedName("solarradiation") val solarradiation: Int? = null,
    @SerializedName("solarenergy") val solarenergy: Double? = null,
    @SerializedName("uvindex") val uvindex: Int? = null,
    @SerializedName("conditions") val conditions: String? = null,
    @SerializedName("icon") val icon: String,
    @SerializedName("stations") val stations: ArrayList<String> = arrayListOf(),
    @SerializedName("source") val source: String? = null,
    @SerializedName("sunrise") val sunrise: String,
    @SerializedName("sunriseEpoch") val sunriseEpoch: Int? = null,
    @SerializedName("sunset") val sunset: String,
    @SerializedName("sunsetEpoch") val sunsetEpoch: Int? = null,
//    @SerializedName("moonphase") val moonphase: Int? = null
)