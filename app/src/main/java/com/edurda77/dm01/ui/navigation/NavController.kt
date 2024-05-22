package com.edurda77.dm01.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.edurda77.dm01.domain.utils.SPLASH_SCREEN
import com.edurda77.dm01.ui.logo.LogoScreen
import com.edurda77.dm01.ui.news.NewsScreen
import com.edurda77.dm01.ui.news_more.MoreScreen
import com.edurda77.dm01.ui.notes.NotesScreen
import com.edurda77.dm01.ui.splash.SplashScreen
import com.edurda77.dm01.ui.video.VideoScreen
import com.edurda77.dm01.ui.welcome.WelcomeScreen

@Composable
fun NavController(
    startDestination: String = SPLASH_SCREEN,
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavigationDestination.SplashScreenDestination.destination) {
            SplashScreen(
                navController = navController
            )
        }
        composable(NavigationDestination.WelcomeScreenDestination.destination) {
            WelcomeScreen(
                navController = navController
            )
        }
        composable(NavigationDestination.LogoScreenDestination.destination) {
            LogoScreen(
                navController = navController
            )
        }
        composable(NavigationDestination.NewsScreenDestination.destination) {
            NewsScreen(
                navController = navController
            )
        }
        composable(NavigationDestination.NotesScreenDestination.destination) {
            NotesScreen(
                navController = navController
            )
        }
        composable(NavigationDestination.VideoScreenDestination.destination) {
            VideoScreen(
                navController = navController
            )
        }
        composable(
            NavigationDestination.NewsMoreScreenDestination.destination,
            arguments = listOf(navArgument("title") {
                type = NavType.StringType
            },
                navArgument("content") {
                    type = NavType.StringType
                },
                navArgument("image") {
                    type = NavType.StringType
                }
            )

        ) {
            MoreScreen(
                navController = navController
            )
        }
        /*composable(
            NavigationDestination.NoteMoreScreenDestination.destination,
            arguments = listOf(navArgument("title") {
                type = NavType.IntType
            },
                navArgument("content") {
                    type = NavType.IntType
                })
        ) {
            NoteMoreScreen(
                navController = navController
            )
        }*/
    }
}