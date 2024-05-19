package com.alexander_nevsky_temple.domain.useCases

import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.repositories.IArticleRepository
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import kotlinx.coroutines.flow.*

class GetArticlesUseCase(
    private val repository: IArticleRepository
) {
    operator fun invoke(): Flow<ActionStatus<Article>> = repository.getList()
}