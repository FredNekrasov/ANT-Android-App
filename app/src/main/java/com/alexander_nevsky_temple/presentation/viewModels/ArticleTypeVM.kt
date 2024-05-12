package com.alexander_nevsky_temple.presentation.viewModels

import androidx.lifecycle.*
import com.alexander_nevsky_temple.domain.model.ArticleType
import com.alexander_nevsky_temple.domain.useCases.articleType.GetArticleTypesUseCase
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class ArticleTypeVM(
    private val getArticleTypesUseCase: GetArticleTypesUseCase
) : ViewModel() {
    private val articleTypesMSF = MutableStateFlow<ActionStatus<ArticleType>>(ActionStatus.Loading(emptyList()))
    val articleTypesSF = articleTypesMSF.asStateFlow()
    init { getArticleTypes() }
    private fun getArticleTypes() {
        viewModelScope.launch {
            getArticleTypesUseCase().flowOn(Dispatchers.IO).collect {
                articleTypesMSF.emit(it)
            }
        }
    }
}