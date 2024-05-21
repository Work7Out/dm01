package com.edurda77.dm01.data.mapper

import com.edurda77.dm01.data.remote.LogoDto
import com.edurda77.dm01.data.remote.NewsDto
import com.edurda77.dm01.data.remote.PluginDto
import com.edurda77.dm01.domain.model.Logo
import com.edurda77.dm01.domain.model.News
import com.edurda77.dm01.domain.model.Plugin


fun List<LogoDto>.convertToLogo(): List<Logo> {
    return this.map {
        Logo(
            title = it.name,
            image = it.image,
            date = it.date,
            url = it.url
        )
    }
}

fun List<PluginDto>.convertToPlugin(): List<Plugin> {
    return this.map {
        Plugin(
            title = it.titlePlugin,
            image = it.imagePlugin,
            url = it.urlPlugin
        )
    }
}

fun List<NewsDto>.convertToNews(): List<News> {
    return this.map {
        News(
            title = it.titleNews,
            image = it.imageNews,
            content = it.content
        )
    }
}