package com.edurda77.dm01.ui.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.edurda77.dm01.ui.theme.background
import com.edurda77.dm01.ui.uikit.NavigationBar

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = background,
        topBar = {
            /*TopAppBar(
                search = state.value.search,
                title = stringResource(id = R.string.notes_short),
                onSearch = {
                    event(VideosEvent.OnSearch(it))
                },
                onClick = {
                    navController.navigate(LOGO_SCREEN)
                }
            )*/
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

        }
    }
}