package com.alexander_nevsky_temple.domain.repositories

import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import kotlinx.coroutines.flow.Flow

interface IArticleRepository {
    fun getList() : Flow<ActionStatus<Article>>
}