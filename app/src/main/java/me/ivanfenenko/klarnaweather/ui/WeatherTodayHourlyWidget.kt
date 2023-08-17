package me.ivanfenenko.klarnaweather.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import me.ivanfenenko.klarnaweather.model.WeatherHourly


@Composable
fun WeatherTodayHourlyWidget(
    weatherHourly: List<WeatherHourly>
) {
    Row(
        modifier = Modifier
            .height(100.dp)
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        weatherHourly.forEach { weather ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(50.dp)
            ) {
                Text(
                    weather.time,
                    modifier = Modifier.padding(
                        vertical = 4.dp
                    )
                )
                Icon(
                    painter = painterResource(weather.icon.value),
                    contentDescription = null,
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
                Text(
                    " ${weather.temperature}° ",
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}