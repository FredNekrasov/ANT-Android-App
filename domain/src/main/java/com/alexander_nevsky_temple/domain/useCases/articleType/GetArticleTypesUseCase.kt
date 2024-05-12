package com.alexander_nevsky_temple.domain.useCases.articleType

import com.alexander_nevsky_temple.domain.model.ArticleType
import com.alexander_nevsky_temple.domain.repositories.IRepository
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import kotlinx.coroutines.flow.Flow

class GetArticleTypesUseCase(
    private val repository: IRepository<ArticleType>
) {
    operator fun invoke(): Flow<ActionStatus<ArticleType>> = repository.getList()
}