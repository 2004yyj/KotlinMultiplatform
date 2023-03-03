package com.example.kmmtest.data

interface KtorDataSource {
    suspend fun getKtorDocs(): String
}