package com.example.kmmtest.di

import io.ktor.client.*
import org.koin.dsl.module

val networkModule = module {
    factory { HttpClient() }
}