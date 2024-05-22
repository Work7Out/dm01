package com.edurda77.dm01.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.dm01.domain.model.News
import com.edurda77.dm01.domain.model.Plugin
import com.edurda77.dm01.domain.repository.RemoteRepository
import com.edurda77.dm01.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository
) : ViewModel() {
    private var _state = MutableStateFlow(NewsScreenState())
    val state = _state.asStateFlow()

    private val _shadowNews = MutableStateFlow<List<News>>(emptyList())
    private val _shadowPlugins = MutableStateFlow<List<Plugin>>(emptyList())


    init {
        viewModelScope.launch {
            async { getNews() }.onAwait
            async { getPlugins() }.onAwait
        }
    }

    fun newsEvent(newsEvent: NewsEvent) {
        when (newsEvent) {
            is NewsEvent.onSearch -> {
                _state.value.copy(
                    search = newsEvent.query,
                    news = _shadowNews.value.filter {
                        it.title.contains(
                            newsEvent.query,
                            ignoreCase = true
                        )
                    },
                    plugins = _shadowPlugins.value.filter {
                        it.title.contains(
                            newsEvent.query,
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



    private fun NewsScreenState.updateState() {
        _state.update {
            this
        }
    }
}