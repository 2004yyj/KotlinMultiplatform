package com.example.kmmtest.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmtest.domain.use_case.GetKtorDocsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getKtorDocsUseCase: GetKtorDocsUseCase
): ViewModel() {

    private val _text = MutableStateFlow("Loading...")
    val text = _text.asStateFlow()

    fun getKtorDocs() {
        viewModelScope.launch {
            _text.emit(getKtorDocsUseCase())
        }
    }
}
