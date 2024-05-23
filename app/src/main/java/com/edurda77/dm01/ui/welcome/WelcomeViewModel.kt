package com.edurda77.dm01.ui.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.dm01.domain.repository.SharedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val sharedRepository: SharedRepository
) : ViewModel() {


    fun setNoFirst() {
        viewModelScope.launch {
            sharedRepository.setSharedFirst(false)
        }
    }

}