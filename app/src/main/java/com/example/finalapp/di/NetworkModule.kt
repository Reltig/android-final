package com.example.finalapp.di

import com.example.finalapp.data.api.IShopApi
import com.example.finalapp.mocks.api.MockShopApi
import org.koin.dsl.module

val networkModule = module {
    single<IShopApi> {MockShopApi()}
}