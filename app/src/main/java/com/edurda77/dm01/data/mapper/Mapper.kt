package com.edurda77.dm01.data.mapper

import com.edurda77.dm01.data.remote.LogoDto
import com.edurda77.dm01.data.remote.NewsDto
import com.edurda77.dm01.data.remote.NoteDto
import com.edurda77.dm01.data.remote.PluginDto
import com.edurda77.dm01.data.remote.VideoDto
import com.edurda77.dm01.domain.model.Logo
import com.edurda77.dm01.domain.model.News
import com.edurda77.dm01.domain.model.Note
import com.edurda77.dm01.domain.model.Plugin
import com.edurda77.dm01.domain.model.Video


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

fun List<NoteDto>.convertToNote(): List<Note> {
    return this.map {
        Note(
            title = it.title,
            image = it.image,
            content = it.content
        )
    }
}

fun List<VideoDto>.convertToVideo(): List<Video> {
    return this.map {
        Video(
            title = it.title,
            image = it.image,
            url = it.url
        )
    }
}