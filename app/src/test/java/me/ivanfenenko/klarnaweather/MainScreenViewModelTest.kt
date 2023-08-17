package me.ivanfenenko.klarnaweather

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import me.ivanfenenko.klarnaweather.repository.WeatherRepository
import me.ivanfenenko.klarnaweather.ui.screens.main.ForecastLoadingState
import me.ivanfenenko.klarnaweather.ui.screens.main.MainScreenViewModel
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import java.io.IOException

class MainScreenViewModelTest {

    @get:Rule
    val coroutineRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val mockWeatherRepository: WeatherRepository = mock()

    @Test
    fun `Default state is loading`() {
        val viewmodel = MainScreenViewModel(mockWeatherRepository)
        assert(viewmodel.loadingState.value == ForecastLoadingState.Loading)
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `When error happens while loading then state will be error`() = runTest {
        val errorMessage = "No Internet"
        whenever(mockWeatherRepository.loadWeatherForecastForCity("Amsterdam")).thenThrow(IOException(errorMessage))
        val viewmodel = MainScreenViewModel(mockWeatherRepository)

        viewmodel.loadCity("Amsterdam")
        runCurrent()

        assert(viewmodel.loadingState.value is ForecastLoadingState.Error)
    }
}
