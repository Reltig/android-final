package com.example.finalapp.state

import androidx.compose.runtime.Stable

@Stable
interface BaseListState {
    val error: String?
    val loading: Boolean
}