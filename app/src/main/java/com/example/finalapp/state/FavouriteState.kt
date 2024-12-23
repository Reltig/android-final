package com.example.finalapp.state

import com.example.finalapp.data.model.dbEntity.FavouriteProductDbEntity
import com.example.finalapp.model.Product

interface FavouriteState: BaseListState {
    val items: List<FavouriteProductDbEntity>
}