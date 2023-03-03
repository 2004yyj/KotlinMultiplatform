package com.example.kmmtest.data.impl

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import com.example.kmmtest.data.KtorDataSource

class KtorDataSourceImpl(
    private val client: HttpClient
): KtorDataSource {
    override suspend fun getKtorDocs(): String {
        return client.get("https://ktor.io/docs/").bodyAsText()
    }
}