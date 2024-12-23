package com.example.finalapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.services.AuthService
import com.example.finalapp.data.DataPreferences
import com.example.finalapp.state.ProfileState
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val auth: AuthService
) : ViewModel()
{
    private val mutableState = MutableListState()
    val viewState = mutableState as ProfileState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            auth.login(email, password)
            mutableState.isAuthentificated = auth.isAuth()
        }
    }

    fun logout() {
        viewModelScope.launch {
            auth.logout()
            mutableState.isAuthentificated = auth.isAuth()
        }
    }

    private class MutableListState : ProfileState {
        override var isAuthentificated: Boolean by mutableStateOf(false)
    }
}