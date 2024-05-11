package com.alexander_nevsky_temple.domain.useCases.article

import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.repositories.IRepository
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import kotlinx.coroutines.flow.StateFlow

class GetArticlesUseCase(
    private val repository: IRepository<Article>
) {
    suspend fun getList() : StateFlow<ActionStatus<Article>> = repository.getList()
}