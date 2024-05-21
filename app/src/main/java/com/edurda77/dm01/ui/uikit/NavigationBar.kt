package com.edurda77.dm01.ui.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.edurda77.dm01.R
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
        IconButton(onClick = {
            navController.navigate(LOGO_SCREEN)
        }) {
            Icon(
                imageVector = if (currentRoute == NavigationDestination.LogoScreenDestination.destination) ImageVector.vectorResource(
                    id = R.drawable.logo_selected
                ) else ImageVector.vectorResource(id = R.drawable.logo_un),
                contentDescription = "",
            )
        }
        IconButton(onClick = {
            navController.navigate(NEWS_SCREEN)
        }) {
            Icon(
                imageVector = if (currentRoute == NavigationDestination.NewsScreenDestination.destination) ImageVector.vectorResource(
                    id = R.drawable.news_sel
                ) else ImageVector.vectorResource(id = R.drawable.news_un),
                contentDescription = "",
            )
        }
        IconButton(onClick = {
            navController.navigate(NOTES_SCREEN)
        }) {
            Icon(
                imageVector = if (currentRoute == NavigationDestination.NotesScreenDestination.destination) ImageVector.vectorResource(
                    id = R.drawable.note_sel
                ) else ImageVector.vectorResource(id = R.drawable.note_un),
                contentDescription = "",
            )
        }
        IconButton(onClick = {
            navController.navigate(VIDEO_SCREEN)
        }) {
            Icon(
                imageVector = if (currentRoute == NavigationDestination.VideoScreenDestination.destination) ImageVector.vectorResource(
                    id = R.drawable.video_sel
                ) else ImageVector.vectorResource(id = R.drawable.video_un),
                contentDescription = "",
            )
        }
    }
}