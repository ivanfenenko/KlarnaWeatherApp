package me.ivanfenenko.klarnaweather

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
