package com.edurda77.dm01.ui.logo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.dm01.domain.model.Logo
import com.edurda77.dm01.domain.model.News
import com.edurda77.dm01.domain.model.Note
import com.edurda77.dm01.domain.model.Plugin
import com.edurda77.dm01.domain.model.Video
import com.edurda77.dm01.domain.repository.RemoteRepository
import com.edurda77.dm01.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogoViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository
) : ViewModel() {
    private var _state = MutableStateFlow(LogoScreenState())
    val state = _state.asStateFlow()

    private val _shadowLogos = MutableStateFlow<List<Logo>>(emptyList())
    private val _shadowNews = MutableStateFlow<List<News>>(emptyList())
    private val _shadowPlugins = MutableStateFlow<List<Plugin>>(emptyList())
    private val _shadowNotes = MutableStateFlow<List<Note>>(emptyList())
    private val _shadowVideo = MutableStateFlow<List<Video>>(emptyList())


    init {
        viewModelScope.launch {
            async { getNews() }.onAwait
            async { getLogos() }.onAwait
            async { getPlugins() }.onAwait
            async { getNotes() }.onAwait
            async { getVideos() }.onAwait
        }
    }

    fun logoEvent(logoEvent: LogoEvent) {
        when (logoEvent) {
            is LogoEvent.onSearch -> {
                _state.value.copy(
                    search = logoEvent.query,
                    logos = _shadowLogos.value.filter {
                        it.title.contains(
                            logoEvent.query,
                            ignoreCase = true
                        )
                    },
                    news = _shadowNews.value.filter {
                        it.title.contains(
                            logoEvent.query,
                            ignoreCase = true
                        )
                    },
                    plugins = _shadowPlugins.value.filter {
                        it.title.contains(
                            logoEvent.query,
                            ignoreCase = true
                        )
                    },
                    videos = _shadowVideo.value.filter {
                        it.title.contains(
                            logoEvent.query,
                            ignoreCase = true
                        )
                    },
                    notes = _shadowNotes.value.filter {
                        it.title.contains(
                            logoEvent.query,
                            ignoreCase = true
                        )
                    },
                )
                    .updateState()
            }
        }
    }

    private suspend fun getNews() {
        when (val result = remoteRepository.getNews()) {
            is Resource.Error -> {

            }

            is Resource.Success -> {
                _shadowNews.value = result.data ?: emptyList()
                _state.value.copy(
                    isLoading = false,
                    news = result.data ?: emptyList()
                )
                    .updateState()
            }
        }
    }

    private suspend fun getLogos() {
        when (val result = remoteRepository.getLogos()) {
            is Resource.Error -> {

            }

            is Resource.Success -> {
                _shadowLogos.value = result.data ?: emptyList()
                _state.value.copy(
                    isLoading = false,
                    logos = result.data ?: emptyList()
                )
                    .updateState()
            }
        }
    }

    private suspend fun getPlugins() {
        when (val result = remoteRepository.getPlugins()) {
            is Resource.Error -> {

            }

            is Resource.Success -> {
                _shadowPlugins.value = result.data ?: emptyList()
                _state.value.copy(
                    isLoading = false,
                    plugins = result.data ?: emptyList()
                )
                    .updateState()
            }
        }
    }

    private suspend fun getNotes() {
        when (val result = remoteRepository.getNotes()) {
            is Resource.Error -> {

            }

            is Resource.Success -> {
                _shadowNotes.value = result.data ?: emptyList()
                _state.value.copy(
                    isLoading = false,
                    notes = result.data ?: emptyList()
                )
                    .updateState()
            }
        }
    }

    private suspend fun getVideos() {
        when (val result = remoteRepository.getVideos()) {
            is Resource.Error -> {

            }

            is Resource.Success -> {
                _shadowVideo.value = result.data ?: emptyList()
                _state.value.copy(
                    isLoading = false,
                    videos = result.data ?: emptyList()
                )
                    .updateState()
            }
        }
    }

    private fun LogoScreenState.updateState() {
        _state.update {
            this
        }
    }
}