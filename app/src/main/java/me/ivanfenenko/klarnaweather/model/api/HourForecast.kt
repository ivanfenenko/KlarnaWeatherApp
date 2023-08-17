package me.ivanfenenko.klarnaweather.model.api

import com.google.gson.annotations.SerializedName

data class HourForecast(
    @SerializedName("datetime") var datetime: String,
    @SerializedName("datetimeEpoch") var datetimeEpoch: Int? = null,
    @SerializedName("temp") var temp: Double,
    @SerializedName("feelslike") var feelslike: Double? = null,
    @SerializedName("humidity") var humidity: Double? = null,
    @SerializedName("dew") var dew: Double? = null,
//    @SerializedName("precip") var precip: Int? = null,
//    @SerializedName("precipprob") var precipprob: Int? = null,
    @SerializedName("snow") var snow: Int? = null,
    @SerializedName("snowdepth") var snowdepth: Int? = null,
    @SerializedName("preciptype") var preciptype: ArrayList<String> = arrayListOf(),
    @SerializedName("windgust") var windgust: Double? = null,
    @SerializedName("windspeed") var windspeed: Double? = null,
//    @SerializedName("winddir") var winddir: Int? = null,
    @SerializedName("pressure") var pressure: Double? = null,
    @SerializedName("visibility") var visibility: Double? = null,
    @SerializedName("cloudcover") var cloudcover: Double? = null,
//    @SerializedName("solarradiation") var solarradiation: Int? = null,
//    @SerializedName("solarenergy") var solarenergy: Int? = null,
    @SerializedName("uvindex") var uvindex: Int? = null,
    @SerializedName("severerisk") var severerisk: Int? = null,
    @SerializedName("conditions") var conditions: String? = null,
    @SerializedName("icon") var icon: String,
    @SerializedName("stations") var stations: ArrayList<String> = arrayListOf(),
    @SerializedName("source") var source: String? = null
)