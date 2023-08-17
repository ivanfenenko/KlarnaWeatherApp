package me.ivanfenenko.klarnaweather.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import me.ivanfenenko.klarnaweather.R
import me.ivanfenenko.klarnaweather.model.WeatherNow
import me.ivanfenenko.klarnaweather.ui.theme.Typography


@Composable
fun WeatherTodayWidget(
    weatherNow: WeatherNow,
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(weatherNow.animation.value)
    )
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )
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
        Text(
            text = weatherNow.cityTitle,
            style = Typography.headlineMedium
        )
        Text(
            style = Typography.headlineSmall,
            text = stringResource(id = R.string.now_temp_format, weatherNow.currentTemperature)
        )
        LottieAnimation(
            composition,
            progress = { progress },
            Modifier.height(200.dp)
        )
        Row {
            Text(
                stringResource(id = R.string.now_sunrise_time, weatherNow.sunrise),
                modifier = Modifier.padding(horizontal = 4.dp),
                style = Typography.bodyMedium
            )
            Text(
                stringResource(id = R.string.now_sunset_time, weatherNow.sunset),
                modifier = Modifier.padding(horizontal = 4.dp),
                style = Typography.bodyMedium
            )
        }
    }
}