package com.alexander_nevsky_temple.domain.useCases.implementation.article

import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.repositories.IRepository
import com.alexander_nevsky_temple.domain.useCases.IGetListUseCase
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus
import kotlinx.coroutines.flow.StateFlow

class GetArticlesUseCase(
    private val repository: IRepository<Article>
) : IGetListUseCase<Article> {
    override suspend fun getList() : StateFlow<ConnectionStatus<Article>> = repository.getList()
}