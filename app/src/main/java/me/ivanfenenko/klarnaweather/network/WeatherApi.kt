package me.ivanfenenko.klarnaweather.network

import me.ivanfenenko.klarnaweather.model.api.ForecastResponseObject
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {

    @GET("VisualCrossingWebServices/rest/services/timeline/{city}")
    suspend fun getWeatherForecastForCity(
        @Path("city") city: String,
        @Query("unitGroup") unitGroup: String = "metric",
        @Query("key") key: String = "TYXBUCRCLC9T9HJ8TG2XEDEL8",
        @Query("contentType") contentType: String = "json",
        @Query("iconSet") iconSet: String = "icons2"
    ): ForecastResponseObject
}
