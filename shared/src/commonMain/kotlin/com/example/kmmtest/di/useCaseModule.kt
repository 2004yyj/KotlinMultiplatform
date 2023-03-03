package com.example.kmmtest.di

import com.example.kmmtest.data.KtorDataSource
import com.example.kmmtest.data.impl.KtorDataSourceImpl
import com.example.kmmtest.domain.repository.KtorRepository
import com.example.kmmtest.domain.repository.impl.KtorRepositoryImpl
import com.example.kmmtest.domain.use_case.GetKtorDocsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetKtorDocsUseCase(get()) }
}