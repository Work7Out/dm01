package com.edurda77.dm01.ui.video

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.dm01.domain.model.Video
import com.edurda77.dm01.domain.repository.RemoteRepository
import com.edurda77.dm01.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideosViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository
) : ViewModel() {
    private var _state = MutableStateFlow(VideoScreenState())
    val state = _state.asStateFlow()

    private val _shadowVideos = MutableStateFlow<List<Video>>(emptyList())


    init {
        viewModelScope.launch {
            getVideos()
        }
    }

    fun videosEvent(videoEvent: VideosEvent) {
        when (videoEvent) {
            is VideosEvent.OnSearch -> {
                _state.value.copy(
                    search = videoEvent.query,
                    videos = _shadowVideos.value.filter {
                        it.title.contains(
                            videoEvent.query,
                            ignoreCase = true
                        )
                    },
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
                _shadowVideos.value = result.data ?: emptyList()
                _state.value.copy(
                    isLoading = false,
                    videos = result.data ?: emptyList()
                )
                    .updateState()
            }
        }
    }





    private fun VideoScreenState.updateState() {
        _state.update {
            this
        }
    }
}