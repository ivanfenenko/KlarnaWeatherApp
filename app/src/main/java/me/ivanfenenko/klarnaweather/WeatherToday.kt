package me.ivanfenenko.klarnaweather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation


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