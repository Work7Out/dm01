package com.edurda77.dm01.ui.notes

sealed class NotesEvent {
    class onSearch(val query:String): NotesEvent()
}