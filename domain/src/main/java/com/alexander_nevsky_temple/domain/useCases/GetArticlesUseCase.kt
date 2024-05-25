package com.alexander_nevsky_temple.domain.useCases

import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.repositories.IArticleRepository
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import kotlinx.coroutines.flow.*

/**
 * This class represents a use case for getting a list of articles.
 *
 * @property repository The repository used to fetch the articles.
 **/
class GetArticlesUseCase(
    private val repository: IArticleRepository
) {
    /**
     * Invoke the use case to get a flow of [ActionStatus] containing [Article] objects.
     * Delegate the execution to the repository and return the result as a flow.
     * @return A flow of [ActionStatus] containing [Article] objects.
     */
    operator fun invoke(): Flow<ActionStatus<Article>> = repository.getList()
}