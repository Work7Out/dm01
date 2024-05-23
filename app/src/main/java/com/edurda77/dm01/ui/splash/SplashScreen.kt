package com.edurda77.dm01.ui.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.edurda77.dm01.R
import com.edurda77.dm01.domain.utils.LOGO_SCREEN
import com.edurda77.dm01.domain.utils.WELCOME_SCREEN
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    scope:CoroutineScope = rememberCoroutineScope(),
    viewModel: SplashViewModel = hiltViewModel()
) {
    val isFirst = viewModel.state.collectAsState()
    scope.launch {
        delay(2000)
        if (isFirst.value) {
            navController.navigate(WELCOME_SCREEN)
        } else {
            navController.navigate(LOGO_SCREEN)
        }
    }
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.splash),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
    }
}