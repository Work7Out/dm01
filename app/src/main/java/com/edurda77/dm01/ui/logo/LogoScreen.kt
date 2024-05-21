package com.edurda77.dm01.ui.logo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.edurda77.dm01.R
import com.edurda77.dm01.ui.theme.background
import com.edurda77.dm01.ui.theme.black
import com.edurda77.dm01.ui.theme.grey
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
    ) {paddings->
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
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    color = black,
                )
            )
        }
    }
}