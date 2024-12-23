package com.example.finalapp.di

import com.example.finalapp.data.api.IAuthApi
import com.example.finalapp.data.api.IShopApi
import com.example.finalapp.mocks.api.MockAuthApi
import com.example.finalapp.mocks.api.MockShopApi
import org.koin.dsl.module

val networkModule = module {
    single<IShopApi> {MockShopApi()}
    single<IAuthApi> { MockAuthApi() }
}