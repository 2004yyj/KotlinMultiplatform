package com.example.kmmtest.domain.repository

interface KtorRepository {
    suspend fun getKtorDocs(): String
}