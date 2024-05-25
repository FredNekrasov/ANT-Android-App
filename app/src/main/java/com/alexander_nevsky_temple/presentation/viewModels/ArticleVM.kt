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

/**
 * Article view model class.
 * When the view model is created, the init function is called.
 * init is used to get articles from the use case and emit them to the state flow.
 * The state flow is used in screens to display articles.
 */
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