package com.edurda77.dm01.ui.news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.edurda77.dm01.R
import com.edurda77.dm01.domain.utils.GRID_MAX_HEIGHT
import com.edurda77.dm01.ui.theme.background
import com.edurda77.dm01.ui.theme.black
import com.edurda77.dm01.ui.uikit.ItemNews
import com.edurda77.dm01.ui.uikit.ItemPlugin
import com.edurda77.dm01.ui.uikit.NavigationBar
import com.edurda77.dm01.ui.uikit.TopAppBar

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    val event = viewModel::newsEvent
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = background,
        topBar = {
            TopAppBar(
                search = state.value.search,
                title = stringResource(id = R.string.news),
                onSearch = {
                    event(NewsEvent.onSearch(it))
                },
                onClick = {
                    navController.popBackStack()
                }
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
            LazyVerticalStaggeredGrid(
                modifier = modifier.heightIn(max = GRID_MAX_HEIGHT.dp),
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 30.dp,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                items(state.value.news) {
                    ItemNews(
                        navController = navController,
                        news = it
                    )
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
            }
            Spacer(modifier = modifier.height(23.dp))
            LazyVerticalStaggeredGrid(
                modifier = modifier.heightIn(max = GRID_MAX_HEIGHT.dp),
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 30.dp,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                items(state.value.plugins) {
                    ItemPlugin(plugin = it)
                }
            }
        }
    }
}