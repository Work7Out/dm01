package com.edurda77.dm01.ui.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.dm01.domain.model.Note
import com.edurda77.dm01.domain.repository.RemoteRepository
import com.edurda77.dm01.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository
) : ViewModel() {
    private var _state = MutableStateFlow(NotesScreenState())
    val state = _state.asStateFlow()

    private val _shadowNotes = MutableStateFlow<List<Note>>(emptyList())


    init {
        viewModelScope.launch {
            getNotes()
        }
    }

    fun notesEvent(notesEvent: NotesEvent) {
        when (notesEvent) {
            is NotesEvent.onSearch -> {
                _state.value.copy(
                    search = notesEvent.query,
                    notes = _shadowNotes.value.filter {
                        it.title.contains(
                            notesEvent.query,
                            ignoreCase = true
                        )
                    },
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





    private fun NotesScreenState.updateState() {
        _state.update {
            this
        }
    }
}