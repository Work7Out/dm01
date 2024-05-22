package com.edurda77.dm01.ui.video

import com.edurda77.dm01.domain.model.Video

data class VideoScreenState(
    val videos:List<Video> = emptyList(),
    val isLoading: Boolean = true,
    val search: String = "",
)
