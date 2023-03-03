package com.example.kmmtest.domain.repository.impl

import com.example.kmmtest.data.KtorDataSource
import com.example.kmmtest.domain.repository.KtorRepository

class KtorRepositoryImpl(
    private val dataSource: KtorDataSource
): KtorRepository {
    override suspend fun getKtorDocs(): String {
        return dataSource.getKtorDocs()
    }
}