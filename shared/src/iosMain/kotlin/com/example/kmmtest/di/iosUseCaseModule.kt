package com.example.kmmtest.di

import com.example.kmmtest.domain.use_case.IosGetKtorDocsUseCase
import org.koin.dsl.module

val iosUseCaseModule = module {
    factory { IosGetKtorDocsUseCase(get()) }
}