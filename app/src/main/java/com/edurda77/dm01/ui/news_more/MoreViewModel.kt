package com.edurda77.dm01.ui.news_more

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoreViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _state = MutableStateFlow(MoreScreenState())
    val state = _state.asStateFlow()


    init {
        viewModelScope.launch {
            val title = savedStateHandle.get<String>("title") ?: return@launch
            val content = savedStateHandle.get<String>("content") ?: return@launch
            val image = savedStateHandle.get<String>("image") ?: return@launch
            _state.value.copy(
                title = title,
                content = content,
                image = image
            )
                .updateState()
        }
    }


    private fun MoreScreenState.updateState() {
        _state.update {
            this
        }
    }
}