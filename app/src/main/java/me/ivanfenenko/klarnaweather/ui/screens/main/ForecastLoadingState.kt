package me.ivanfenenko.klarnaweather.ui.screens.main

sealed class ForecastLoadingState {
    data object Loading : ForecastLoadingState()

    data class Error(
        val errorText: String
    ) : ForecastLoadingState()

    data object Ready : ForecastLoadingState()
}