package com.alexander_nevsky_temple

import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.repositories.IArticleRepository
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 *  Fake repository for testing.
 *  It returns list of articles with fake data.
 *  @see IArticleRepository for more details
 */
class FakeRepository : IArticleRepository {
    override fun getList(): Flow<ActionStatus<Article>> = flow {
        emit(ActionStatus.Loading(emptyList()))
        val articleList = listOf(
            Article("title1", "description1", "date1", "1", listOf("a", "1")),
            Article("title2", "description2", "date2", "2", listOf("b", "2")),
            Article("title3", "description3", "date3", "3", listOf("c", "3")),
            Article("title4", "description4", "date4", "4", listOf("d", "4")),
            Article("title5", "description5", "date5", "5", listOf("e", "5"))
        )
        emit(ActionStatus.Success(articleList))
    }
}