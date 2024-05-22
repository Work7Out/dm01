package com.edurda77.dm01.ui.logo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.edurda77.dm01.R
import com.edurda77.dm01.domain.utils.NEWS_SCREEN
import com.edurda77.dm01.domain.utils.NOTES_SCREEN
import com.edurda77.dm01.domain.utils.VIDEO_SCREEN
import com.edurda77.dm01.ui.theme.background
import com.edurda77.dm01.ui.theme.black
import com.edurda77.dm01.ui.uikit.ItemDigest
import com.edurda77.dm01.ui.uikit.ItemNews
import com.edurda77.dm01.ui.uikit.ItemNote
import com.edurda77.dm01.ui.uikit.ItemPlugin
import com.edurda77.dm01.ui.uikit.ItemVideo
import com.edurda77.dm01.ui.uikit.NavigationBar
import com.edurda77.dm01.ui.uikit.TopAppBarLogo

@Composable
fun LogoScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: LogoViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    val event = viewModel::logoEvent
    /*val scrollState = rememberScrollableState { delta ->
        offset += delta
        delta
    }*/
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = background,
        topBar = {
            TopAppBarLogo(
                search = state.value.search,
                event = event
            )
        },
        bottomBar = {
            NavigationBar(navController = navController)
        }
    ) { paddings ->
        Column(
            modifier = modifier
                .padding(paddings)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 30.dp),
        ) {
            Text(
                text = stringResource(R.string.digest),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = black,
                    textDecoration = TextDecoration.Underline
                )
            )
            Spacer(modifier = modifier.height(23.dp))
            LazyVerticalStaggeredGrid(
                modifier = modifier.heightIn(max = 400.dp),
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 30.dp,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                items(state.value.logos) {
                    ItemDigest(logo = it)
                }
            }
            Spacer(modifier = modifier.height(50.dp))
            Row(
                modifier = modifier.clickable {
                    navController.navigate(NEWS_SCREEN)
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.news),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = black,
                        textDecoration = TextDecoration.Underline
                    )
                )
                Spacer(modifier = modifier.width(2.dp))
                IconButton(onClick = {
                    navController.navigate(NEWS_SCREEN)
                }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            id = R.drawable.baseline_arrow_back_24
                        ),
                        contentDescription = "",
                        tint = black
                    )
                }
            }
            Spacer(modifier = modifier.height(23.dp))
            LazyVerticalStaggeredGrid(
                modifier = modifier.heightIn(max = 400.dp),
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 30.dp,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                items(state.value.news) {
                    ItemNews(news = it)
                }
            }
            Spacer(modifier = modifier.height(50.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.plugins),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = black,
                        textDecoration = TextDecoration.Underline
                    )
                )
                Spacer(modifier = modifier.width(2.dp))
                IconButton(onClick = {
                    //navController.navigate(PLU)
                }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            id = R.drawable.baseline_arrow_back_24
                        ),
                        contentDescription = "",
                        tint = black
                    )
                }
            }
            Spacer(modifier = modifier.height(23.dp))
            LazyVerticalStaggeredGrid(
                modifier = modifier.heightIn(max = 400.dp),
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 30.dp,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                items(state.value.plugins) {
                    ItemPlugin(plugin = it)
                }
            }
            Spacer(modifier = modifier.height(50.dp))
            Row(
                modifier = modifier.clickable {
                    navController.navigate(NOTES_SCREEN)
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.notes),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = black,
                        textDecoration = TextDecoration.Underline
                    )
                )
                Spacer(modifier = modifier.width(2.dp))
                IconButton(onClick = {
                    navController.navigate(NOTES_SCREEN)
                }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            id = R.drawable.baseline_arrow_back_24
                        ),
                        contentDescription = "",
                        tint = black
                    )
                }
            }
            Spacer(modifier = modifier.height(23.dp))
            LazyVerticalStaggeredGrid(
                modifier = modifier.heightIn(max = 400.dp),
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 30.dp,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                items(state.value.notes) {
                    ItemNote(note = it)
                }
            }
            Spacer(modifier = modifier.height(50.dp))
            Row(
                modifier = modifier.clickable {
                    navController.navigate(VIDEO_SCREEN)
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.video),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = black,
                        textDecoration = TextDecoration.Underline
                    )
                )
                Spacer(modifier = modifier.width(2.dp))
                IconButton(onClick = {
                    navController.navigate(VIDEO_SCREEN)
                }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            id = R.drawable.baseline_arrow_back_24
                        ),
                        contentDescription = "",
                        tint = black
                    )
                }
            }
            Spacer(modifier = modifier.height(23.dp))
            LazyVerticalStaggeredGrid(
                modifier = modifier.heightIn(max = 400.dp),
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 30.dp,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                items(state.value.videos) {
                    ItemVideo(video = it)
                }
            }
        }
    }
}