package com.example.finalapp.di

import com.example.finalapp.data.mapper.ShopResponseMapper
import com.example.finalapp.data.repository.ShopRepository
import com.example.finalapp.data.repository.interfaces.IShopRepository
import org.koin.core.module.dsl.viewModel
import com.example.finalapp.viewModel.ShopViewModel
import org.koin.dsl.module

val rootModule = module {
    single<IShopRepository> { ShopRepository(get(), get()) }
    factory { ShopResponseMapper() }
    viewModel{ ShopViewModel(get()) }
}