package com.edurda77.dm01.ui.uikit

import android.content.Intent
import android.net.Uri
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
import com.edurda77.dm01.domain.model.Plugin
import com.edurda77.dm01.ui.theme.black

@Composable
fun ItemPlugin(
    modifier: Modifier = Modifier,
    plugin: Plugin,
) {
    val context = LocalContext.current
    Column (
        modifier = modifier.clickable {
            val uri = Uri.parse(plugin.url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            context.startActivity(intent)
        }
    ) {
        AsyncImage(
            model = plugin.image,
            contentDescription = "",
            contentScale = ContentScale.FillWidth)
        Spacer(modifier = modifier.height(5.dp))
        Text(
            text = plugin.title,
            style = TextStyle(
                fontSize = 11.sp,
                fontWeight = FontWeight(600),
                color = black,
            )
        )
    }
}