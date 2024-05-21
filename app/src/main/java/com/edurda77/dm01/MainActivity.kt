package com.edurda77.dm01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.edurda77.dm01.ui.navigation.NavController
import com.edurda77.dm01.ui.theme.Dm01Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dm01Theme {
                NavController()
            }
        }
    }
}