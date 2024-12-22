package com.example.finalapp.utils

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.ViewModel
import com.example.finalapp.viewModel.CartViewModel
import org.koin.androidx.compose.koinViewModel
import com.example.finalapp.viewModel.IUpdatableViewModel

/*
object ViewModelUtils {
    @Composable
    fun Get() {
        val viewModel = koinViewModel<T>()
        DisposableEffect(this) {
            val observer = LifecycleEventObserver { _, event ->
                when (event) {
                    Lifecycle.Event.ON_RESUME -> {
                        Log.d("on resume", "1")
                    }
                    else -> {}
                }
            }
            lifecycleOwner.lifecycle.addObserver(observer)
            onDispose {
                lifecycleOwner.lifecycle.removeObserver(observer)
            }
        }
        return viewModel
    }
}*/
