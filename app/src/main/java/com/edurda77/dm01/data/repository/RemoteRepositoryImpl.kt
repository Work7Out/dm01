package com.edurda77.dm01.data.repository

import com.edurda77.dm01.data.mapper.convertToLogo
import com.edurda77.dm01.data.mapper.convertToNews
import com.edurda77.dm01.data.mapper.convertToNote
import com.edurda77.dm01.data.mapper.convertToPlugin
import com.edurda77.dm01.data.mapper.convertToVideo
import com.edurda77.dm01.data.remote.ApiRemote
import com.edurda77.dm01.domain.model.Logo
import com.edurda77.dm01.domain.model.News
import com.edurda77.dm01.domain.model.Note
import com.edurda77.dm01.domain.model.Plugin
import com.edurda77.dm01.domain.model.Video
import com.edurda77.dm01.domain.repository.RemoteRepository
import com.edurda77.dm01.domain.utils.Resource
import com.edurda77.dm01.domain.utils.UNKNOWM_ERROR
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val apiRemote: ApiRemote
) : RemoteRepository {
    override suspend fun getLogos(): Resource<List<Logo>> {
        return try {
            val result = apiRemote.getLogos().convertToLogo()
            Resource.Success(result)
        } catch (e: Exception) {
            Resource.Error(e.message ?: UNKNOWM_ERROR)
        }
    }

    override suspend fun getNews(): Resource<List<News>> {
        return try {
            val result = apiRemote.getNews().convertToNews()
            Resource.Success(result)
        } catch (e: Exception) {
            Resource.Error(e.message ?: UNKNOWM_ERROR)
        }
    }

    override suspend fun getPlugins(): Resource<List<Plugin>> {
        return try {
            val result = apiRemote.getPlugins().convertToPlugin()
            Resource.Success(result)
        } catch (e: Exception) {
            Resource.Error(e.message ?: UNKNOWM_ERROR)
        }
    }

    override suspend fun getNotes(): Resource<List<Note>> {
        return try {
            val result = apiRemote.getNotes().convertToNote()
            Resource.Success(result)
        } catch (e: Exception) {
            Resource.Error(e.message ?: UNKNOWM_ERROR)
        }
    }

    override suspend fun getVideos(): Resource<List<Video>> {
        return try {
            val result = apiRemote.getVideos().convertToVideo()
            Resource.Success(result)
        } catch (e: Exception) {
            Resource.Error(e.message ?: UNKNOWM_ERROR)
        }
    }
}