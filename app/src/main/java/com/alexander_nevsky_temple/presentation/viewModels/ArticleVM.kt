package com.alexander_nevsky_temple.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.useCases.GetArticlesUseCase
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import com.alexander_nevsky_temple.domain.utils.ActionStatus.Loading
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ArticleVM(
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {
    private val allArticles = MutableStateFlow<ActionStatus<Article>>(Loading(emptyList()))
    val articlesSF = allArticles.asStateFlow()
    init {
        viewModelScope.launch {
            getArticlesUseCase().flowOn(Dispatchers.IO).collectLatest {
                allArticles.emit(it)
            }
        }
    }
}