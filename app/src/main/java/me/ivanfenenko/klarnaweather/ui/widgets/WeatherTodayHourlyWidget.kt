package me.ivanfenenko.klarnaweather.ui.widgets

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.ivanfenenko.klarnaweather.R
import me.ivanfenenko.klarnaweather.ui.model.WeatherHourly
import me.ivanfenenko.klarnaweather.ui.theme.Typography


@Composable
fun WeatherTodayHourlyWidget(
    weatherHourly: List<WeatherHourly>
) {
    Column {
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 8.dp),
            style = Typography.bodyMedium,
            text = stringResource(R.string.label_today_forecast)
        )
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
                    modifier = Modifier
                        .clickable(onClick = {})
                        .padding(4.dp),
                ) {
                    Text(
                        weather.time,
                        style = Typography.labelLarge,
                        modifier = Modifier.padding(
                            vertical = 4.dp
                        )
                    )
                    Icon(
                        painter = painterResource(weather.icon.value),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(4.dp)
                            .height(30.dp)
                            .width(40.dp)
                    )
                    Text(
                        " ${weather.temperature}° ",
                        style = Typography.labelLarge,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}