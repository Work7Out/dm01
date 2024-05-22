package com.edurda77.dm01.ui.uikit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.edurda77.dm01.domain.model.News
import com.edurda77.dm01.ui.theme.black

@Composable
fun ItemNews(
    modifier: Modifier = Modifier,
    news: News,
) {
    val context = LocalContext.current
    Column (
        modifier = modifier.clickable {

        }
    ) {
        AsyncImage(
            model = news.image,
            contentDescription = "",
            contentScale = ContentScale.FillWidth)
        Spacer(modifier = modifier.height(5.dp))
        Text(
            text = news.title,
            style = TextStyle(
                fontSize = 11.sp,
                fontWeight = FontWeight(600),
                color = black,
            )
        )
    }
}