package com.example.kmmtest.di

import com.example.kmmtest.data.KtorDataSource
import com.example.kmmtest.data.impl.KtorDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<KtorDataSource> { KtorDataSourceImpl(get()) }
}