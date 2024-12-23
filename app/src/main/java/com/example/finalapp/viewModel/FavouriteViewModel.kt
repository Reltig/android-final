package com.example.finalapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.services.AuthService
import com.example.finalapp.data.DataPreferences
import com.example.finalapp.data.dao.FavouritesDao
import com.example.finalapp.data.db.FavouriteDatabase
import com.example.finalapp.data.model.dbEntity.FavouriteProductDbEntity
import com.example.finalapp.model.Product
import com.example.finalapp.state.BaseListState
import com.example.finalapp.state.FavouriteState
import com.example.finalapp.state.ProfileState
import kotlinx.coroutines.launch

class FavouriteViewModel(
    private val favouritesDao: FavouritesDao
) : ViewModel()
{
    private val mutableState = MutableListState()
    val viewState = mutableState as FavouriteState

    init {
        initDb()
    }

    private fun initDb() {
        viewModelScope.launch {
            mutableState.items = favouritesDao.getAll()
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch {
            favouritesDao.deleteById(id)
            mutableState.items = favouritesDao.getAll()
        }
    }

    private class MutableListState : FavouriteState {
        override var items: List<FavouriteProductDbEntity> by mutableStateOf(emptyList())
        override var error: String? by mutableStateOf(null)
        override var loading: Boolean by mutableStateOf(false)
    }
}