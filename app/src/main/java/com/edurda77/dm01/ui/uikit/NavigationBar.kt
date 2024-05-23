package com.edurda77.dm01.ui.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.edurda77.dm01.R
import com.edurda77.dm01.domain.utils.ABOUT_SCREEN
import com.edurda77.dm01.domain.utils.LOGO_SCREEN
import com.edurda77.dm01.domain.utils.NEWS_SCREEN
import com.edurda77.dm01.domain.utils.NOTES_SCREEN
import com.edurda77.dm01.domain.utils.VIDEO_SCREEN
import com.edurda77.dm01.ui.navigation.NavigationDestination
import com.edurda77.dm01.ui.theme.yellow

@Composable
fun NavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val currentRoute = navController.currentDestination?.route
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = yellow)
            .padding(horizontal = 17.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TextButton(onClick = {
            navController.navigate(LOGO_SCREEN)
        }) {
            Image(
                modifier = modifier.width(40.dp),
                painter = if (currentRoute == LOGO_SCREEN) painterResource(id = R.drawable.main_sel) else painterResource(
                    id = R.drawable.main_un
                ),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
        }
        TextButton(onClick = {
            navController.navigate(NEWS_SCREEN)
        }) {
            Image(
                modifier = modifier.width(40.dp),
                painter = if (currentRoute == NEWS_SCREEN) painterResource(id = R.drawable.news_sel) else painterResource(
                    id = R.drawable.news_un
                ),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
        }
        TextButton(onClick = {
            navController.navigate(NOTES_SCREEN)
        }) {
            Image(
                modifier = modifier.width(40.dp),
                painter = if (currentRoute == NOTES_SCREEN) painterResource(id = R.drawable.notes_sel) else painterResource(
                    id = R.drawable.notes_un
                ),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
        }
        TextButton(onClick = {
            navController.navigate(VIDEO_SCREEN)
        }) {
            Image(
                modifier = modifier.width(40.dp),
                painter = if (currentRoute == VIDEO_SCREEN) painterResource(id = R.drawable.video_sel) else painterResource(
                    id = R.drawable.video_un
                ),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
        }
        TextButton(onClick = {
            navController.navigate(ABOUT_SCREEN)
        }) {
            Image(
                modifier = modifier.width(40.dp),
                painter = if (currentRoute == ABOUT_SCREEN) painterResource(id = R.drawable.video_sel) else painterResource(
                    id = R.drawable.video_un
                ),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
        }
    }
}