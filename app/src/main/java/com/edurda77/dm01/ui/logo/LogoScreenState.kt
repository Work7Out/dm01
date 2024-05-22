package com.edurda77.dm01.ui.logo

import com.edurda77.dm01.domain.model.Logo
import com.edurda77.dm01.domain.model.News
import com.edurda77.dm01.domain.model.Note
import com.edurda77.dm01.domain.model.Plugin
import com.edurda77.dm01.domain.model.Video

data class LogoScreenState(
    val news:List<News> = emptyList(),
    val logos:List<Logo> = emptyList(),
    val plugins: List<Plugin>  = emptyList(),
    val notes:List<Note> = emptyList(),
    val videos: List<Video>  = emptyList(),
    val isLoading: Boolean = true,
    val search: String = "",
)
