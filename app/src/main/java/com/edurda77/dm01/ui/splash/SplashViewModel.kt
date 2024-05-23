package com.edurda77.dm01.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.dm01.domain.repository.SharedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val sharedRepository: SharedRepository
) : ViewModel() {
    private var _state = MutableStateFlow(true)
    val state = _state.asStateFlow()



    init {
        viewModelScope.launch {
            _state.value = sharedRepository.getSharedFirst()
        }
    }

}