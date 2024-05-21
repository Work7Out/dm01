package com.edurda77.dm01.ui.logo

sealed class LogoEvent {
    class onSearch(val query:String): LogoEvent()
}