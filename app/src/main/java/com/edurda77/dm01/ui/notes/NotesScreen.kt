package com.edurda77.dm01.ui.notes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.edurda77.dm01.R
import com.edurda77.dm01.ui.theme.background
import com.edurda77.dm01.ui.uikit.ItemNote
import com.edurda77.dm01.ui.uikit.NavigationBar
import com.edurda77.dm01.ui.uikit.TopAppBar

@Composable
fun NotesScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: NotesViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    val event = viewModel::notesEvent
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = background,
        topBar = {
            TopAppBar(
                search = state.value.search,
                title = stringResource(id = R.string.notes_short),
                onSearch = {
                    event(NotesEvent.onSearch(it))
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
                .padding(horizontal = 30.dp),
        ) {
            LazyVerticalStaggeredGrid(
                modifier = modifier,
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 30.dp,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                items(state.value.notes) {
                    ItemNote(
                        navController = navController,
                        note = it
                    )
                }
            }
        }
    }
}