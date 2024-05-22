package com.edurda77.dm01.ui.notes

import com.edurda77.dm01.domain.model.Note

data class NotesScreenState(
    val notes:List<Note> = emptyList(),
    val isLoading: Boolean = true,
    val search: String = "",
)
