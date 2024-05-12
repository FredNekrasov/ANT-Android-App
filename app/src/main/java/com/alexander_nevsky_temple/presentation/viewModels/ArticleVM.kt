package com.alexander_nevsky_temple.presentation.viewModels

import androidx.lifecycle.*
import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.useCases.article.GetArticlesUseCase
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class ArticleVM(
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {
    private val articlesMSF = MutableStateFlow<ActionStatus<Article>>(ActionStatus.Loading(emptyList()))
    val articlesSF = articlesMSF.asStateFlow()
    fun getArticles(type: String) {
        viewModelScope.launch {
            getArticlesUseCase(type).flowOn(Dispatchers.IO).collect {
                articlesMSF.emit(it)
            }
        }
    }
}