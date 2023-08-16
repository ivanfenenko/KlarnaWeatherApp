package me.ivanfenenko.klarnaweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import me.ivanfenenko.klarnaweather.ui.theme.KlarnaWeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KlarnaWeatherTheme {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.anim_cloudy))
                val progress by animateLottieCompositionAsState(
                    composition,
                    iterations = LottieConstants.IterateForever
                )
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        WeatherToday(composition, progress, "Berlin", "21°C", "Sunrise: 09:12", "Sunset: 23:15")
                        WeatherTodayHourly()
                        WeatherWeekForecast()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.anim_cloudy))
    val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)
    KlarnaWeatherTheme {
        WeatherToday(composition, progress, "Berlin", "21°C", "Sunrise: 09:12", "Sunset: 23:15")
    }
}