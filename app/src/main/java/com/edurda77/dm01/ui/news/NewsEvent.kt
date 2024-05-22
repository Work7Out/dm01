package com.edurda77.dm01.ui.news

sealed class NewsEvent {
    class onSearch(val query:String): NewsEvent()
}