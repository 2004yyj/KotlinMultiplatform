package com.example.kmmtest.domain.use_case

import com.example.kmmtest.domain.repository.KtorRepository
import com.example.kmmtest.provider.MainScopeProvider
import com.futuremind.koru.ToNativeClass

@ToNativeClass(name = "IosGetKtorDocsUseCase", launchOnScope = MainScopeProvider::class)
class GetKtorDocsUseCase(
    private val repository: KtorRepository
) {
    suspend operator fun invoke() = repository.getKtorDocs()
}