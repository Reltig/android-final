package com.example.finalapp.di

import com.example.finalapp.services.AuthService
import com.example.finalapp.data.mapper.ShopResponseMapper
import com.example.finalapp.data.repository.ShopRepository
import com.example.finalapp.data.repository.interfaces.IShopRepository
import com.example.finalapp.viewModel.CartViewModel
import com.example.finalapp.viewModel.ProfileViewModel
import org.koin.core.module.dsl.viewModel
import com.example.finalapp.viewModel.ShopViewModel
import org.koin.dsl.module

val rootModule = module {
    single { AuthService(get()) }
    single<IShopRepository> { ShopRepository(get(), get()) }
    factory { ShopResponseMapper() }
    viewModel{ ShopViewModel(get()) }
    viewModel { CartViewModel(get(), get()) }
    viewModel { ProfileViewModel(get()) }
}