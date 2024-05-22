package com.edurda77.dm01.ui.navigation

import com.edurda77.dm01.domain.utils.LOGO_SCREEN
import com.edurda77.dm01.domain.utils.MORE_SCREEN
import com.edurda77.dm01.domain.utils.NEWS_SCREEN
import com.edurda77.dm01.domain.utils.NOTES_SCREEN
import com.edurda77.dm01.domain.utils.SPLASH_SCREEN
import com.edurda77.dm01.domain.utils.VIDEO_SCREEN
import com.edurda77.dm01.domain.utils.WELCOME_SCREEN


sealed class NavigationDestination (val destination: String){
    data object SplashScreenDestination: NavigationDestination(SPLASH_SCREEN)
    data object WelcomeScreenDestination: NavigationDestination(WELCOME_SCREEN)
    data object LogoScreenDestination: NavigationDestination(LOGO_SCREEN)
    data object NewsScreenDestination: NavigationDestination(NEWS_SCREEN)
    data object NotesScreenDestination: NavigationDestination(NOTES_SCREEN)
    data object VideoScreenDestination: NavigationDestination(VIDEO_SCREEN)
    data object NewsMoreScreenDestination: NavigationDestination("$MORE_SCREEN/{title}/{content}/{image}")
    //data object NoteMoreScreenDestination: NavigationDestination("$NOTE_MORE_SCREEN/{title}/{content}")
}
