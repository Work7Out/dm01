package com.edurda77.dm01.data.remote

import retrofit2.http.GET

interface ApiRemote {
    @GET("main/logos")
    suspend fun getLogos () : List<LogoDto>

    @GET("main/news")
    suspend fun getNews () : List<NewsDto>

    @GET("main/plugins")
    suspend fun getPlugins () : List<PluginDto>

    @GET("main/notes")
    suspend fun getNotes () : List<NoteDto>

    @GET("main/video")
    suspend fun getVideos () : List<VideoDto>
}