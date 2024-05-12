package com.alexander_nevsky_temple.domain.useCases.article

import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.repositories.IRepository
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import com.alexander_nevsky_temple.domain.utils.ActionStatus.Success
import kotlinx.coroutines.flow.*

class GetArticlesUseCase(
    private val repository: IRepository<Article>
) {
    operator fun invoke(type: String) : Flow<ActionStatus<Article>> = repository.getList().map {
        val articleMap = it.list.groupBy { article -> article.articleType.type }
        Success(articleMap[type] ?: emptyList())
    }
}