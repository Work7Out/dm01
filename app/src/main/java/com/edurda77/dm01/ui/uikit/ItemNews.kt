package com.edurda77.dm01.ui.uikit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.edurda77.dm01.domain.model.News
import com.edurda77.dm01.domain.utils.MORE_SCREEN
import com.edurda77.dm01.ui.theme.black
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun ItemNews(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    news: News,
) {
    val encodedUrl = URLEncoder.encode(news.image, StandardCharsets.UTF_8.toString())
    Column (
        modifier = modifier.clickable {
            navController.navigate("$MORE_SCREEN/${news.title}/${news.content}/$encodedUrl")
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