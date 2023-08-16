package me.ivanfenenko.klarnaweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
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

@Composable
fun WeatherToday(
    composition: LottieComposition?,
    progress: Float,
    cityTitle: String,
    currentTemperature: String,
    sunrise: String,
    sunset: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 32.dp
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(cityTitle)
        Text(currentTemperature)
        LottieAnimation(
            composition,
            progress = { progress },
            Modifier.height(200.dp)
        )
        Row {
            Text(
                sunrise,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                sunset,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
    }
}

@Composable
fun WeatherTodayHourly(
) {
    Row(
        modifier = Modifier
            .height(100.dp)
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        repeat(24) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(50.dp)
            ) {
                Text(
                    "12:00",
                    modifier = Modifier.padding(
                        vertical = 4.dp
                    )
                )
                Icon(
                    painter = painterResource(R.drawable.ic_clear_day),
                    contentDescription = null,
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
                Text(
                    " ${it + 1}° ",
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
fun WeatherWeekForecast(
) {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(
                horizontal = 16.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val week = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
        week.forEach {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_hail),
                    contentDescription = null,
                    modifier = Modifier
                        .height(64.dp)
                        .width(64.dp)
                )
                Text(it)
                Text("${week.indexOf(it)}°")
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