package com.edurda77.dm01.domain.repository

import com.edurda77.dm01.domain.model.Logo
import com.edurda77.dm01.domain.model.News
import com.edurda77.dm01.domain.model.Note
import com.edurda77.dm01.domain.model.Plugin
import com.edurda77.dm01.domain.model.Video
import com.edurda77.dm01.domain.utils.Resource

interface RemoteRepository {
    suspend fun getLogos(): Resource<List<Logo>>
    suspend fun getNews(): Resource<List<News>>
    suspend fun getPlugins(): Resource<List<Plugin>>
    suspend fun getNotes(): Resource<List<Note>>
    suspend fun getVideos(): Resource<List<Video>>
}