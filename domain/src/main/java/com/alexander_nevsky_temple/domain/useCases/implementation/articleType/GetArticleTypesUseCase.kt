package com.alexander_nevsky_temple.domain.useCases.implementation.articleType

import com.alexander_nevsky_temple.domain.model.ArticleType
import com.alexander_nevsky_temple.domain.repositories.IRepository
import com.alexander_nevsky_temple.domain.useCases.IGetListUseCase
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus
import kotlinx.coroutines.flow.StateFlow

class GetArticleTypesUseCase(
    private val repository: IRepository<ArticleType>
) : IGetListUseCase<ArticleType> {
    override suspend fun getList() : StateFlow<ConnectionStatus<ArticleType>> = repository.getList()
}