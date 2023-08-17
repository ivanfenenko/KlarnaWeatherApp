package me.ivanfenenko.klarnaweather.ui.widgets

import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import me.ivanfenenko.klarnaweather.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWidget(
    onCitySelected: (String) -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }
    TopAppBar(
        title = {},
        actions = {
            IconButton(onClick = { menuExpanded = !menuExpanded }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More",
                )
            }
            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = { menuExpanded = false },
            ) {
                // 6
                DropdownMenuItem(
                    text = {
                        Text(stringResource(R.string.menu_option_berlin))
                    },
                    onClick = {
                        onCitySelected("Berlin")
                        menuExpanded = false
                    },
                )
                DropdownMenuItem(
                    text = {
                        Text(stringResource(R.string.menu_option_london))
                    },
                    onClick = {
                        onCitySelected("London")
                        menuExpanded = false
                    },
                )
                DropdownMenuItem(
                    text = {
                        Text(stringResource(R.string.menu_option_amsterdam))
                    },
                    onClick = {
                        onCitySelected("Amsterdam")
                        menuExpanded = false
                    },
                )
            }
        }
    )
}