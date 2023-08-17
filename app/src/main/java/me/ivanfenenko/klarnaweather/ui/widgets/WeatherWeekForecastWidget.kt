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
import me.ivanfenenko.klarnaweather.ui.model.WeatherDaily
import me.ivanfenenko.klarnaweather.ui.theme.Typography


@Composable
fun WeatherWeekForecastWidget(
    weatherDaily: List<WeatherDaily>
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 8.dp),
    ) {
        Text(
            text = stringResource(R.string.label_week_forecast),
            style = Typography.bodyMedium
        )
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(
                    horizontal = 16.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            weatherDaily.forEach { weather ->
                Column(
                    modifier = Modifier
                        .clickable(onClick = {})
                        .padding(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(weather.icon.value),
                        contentDescription = null,
                        modifier = Modifier
                            .height(64.dp)
                            .width(64.dp)
                    )
                    Text(
                        text = weather.day,
                        style = Typography.labelLarge
                    )
                    Text(
                        text = "${weather.temperature}°",
                        style = Typography.labelLarge
                    )
                }
            }
        }
    }
}
