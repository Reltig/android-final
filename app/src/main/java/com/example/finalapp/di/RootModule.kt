package com.example.finalapp.di

import org.koin.core.module.dsl.viewModel
import com.example.finalapp.viewModel.ShopViewModel
import org.koin.dsl.module

val rootModule = module {
    viewModel{ ShopViewModel() }
}