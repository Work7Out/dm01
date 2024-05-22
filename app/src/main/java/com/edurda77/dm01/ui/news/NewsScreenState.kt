package com.edurda77.dm01.ui.news

import com.edurda77.dm01.domain.model.News
import com.edurda77.dm01.domain.model.Plugin

data class NewsScreenState(
    val news:List<News> = emptyList(),
    val plugins: List<Plugin>  = emptyList(),
    val isLoading: Boolean = true,
    val search: String = "",
)
