package com.example.kmmtest.di

import org.koin.core.context.startKoin

fun initAndroidDependencies() = startKoin {
    modules(networkModule, dataSourceModule, repositoryModule, useCaseModule)
}