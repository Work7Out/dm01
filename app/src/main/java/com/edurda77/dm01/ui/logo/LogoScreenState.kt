package com.edurda77.dm01.ui.logo

import com.edurda77.dm01.domain.model.Logo
import com.edurda77.dm01.domain.model.News
import com.edurda77.dm01.domain.model.Plugin

data class LogoScreenState(
    val news:List<News> = emptyList(),
    val logos:List<Logo> = emptyList(),
    val plugins: List<Plugin>  = emptyList(),
    val isLoading: Boolean = true,
    val search: String = "",

)
