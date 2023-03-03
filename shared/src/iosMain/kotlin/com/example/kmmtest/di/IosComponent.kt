package com.example.kmmtest.di

import com.example.kmmtest.domain.use_case.IosGetKtorDocsUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin

fun initIosDependencies() = startKoin {
    modules(networkModule, dataSourceModule, repositoryModule, useCaseModule, iosUseCaseModule)
}

class IosComponent: KoinComponent {
    fun providesGetKtorDocsUseCase(): IosGetKtorDocsUseCase = get()
}