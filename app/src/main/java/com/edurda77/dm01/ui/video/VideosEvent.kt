package com.edurda77.dm01.ui.video

sealed class VideosEvent {
    class OnSearch(val query:String): VideosEvent()
}