package com.edurda77.dm01.ui.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ZoomableImage(
    model: Int,
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val size = remember {
        mutableStateOf(screenWidth * 0.5f)
    }
    Image(
        painter = painterResource(id = model),
        contentDescription = "",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .size(size.value)
            .clickable {
                size.value = if (size.value == screenWidth*1.5f) screenWidth * 0.5f else screenWidth*1.5f
            }

    )
}