package com.alexander_nevsky_temple.data.repositories

import com.alexander_nevsky_temple.data.local.dao.IArticleDao
import com.alexander_nevsky_temple.data.mappers.*
import com.alexander_nevsky_temple.data.remote.dto.ArticleDto
import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.repositories.IArticleRepository
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import com.alexander_nevsky_temple.domain.utils.ActionStatus.*
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus.*
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.*
import io.ktor.client.request.get
import io.ktor.serialization.JsonConvertException
import kotlinx.coroutines.flow.*

class ArticleRepository(
    private val articleDao: IArticleDao,
    private val client: HttpClient
) : IArticleRepository {
    override fun getList() : Flow<ActionStatus<Article>> = flow {
        val articleList = articleDao.getAll().map { it.toModel() }
        emit(Loading(articleList))
        val articleDtoList = client.get("/api/v1/chapter").body<List<ArticleDto>?>()
        if(!articleDtoList.isNullOrEmpty()) {
            articleDtoList.forEach { articleDao.insert(it.toEntity()) }
            emit(Success(articleDtoList.map { it.toModel() }))
        } else emit(Error(articleList, NO_DATA))
    }.catch { ex ->
        val articleList = articleDao.getAll().map { it.toModel() }
        when(ex) {
            is ServerResponseException -> emit(Error(articleList, CONNECTION_ERROR))
            is RedirectResponseException -> emit(Error(articleList, CONNECTION_ERROR))
            is HttpRequestTimeoutException -> emit(Error(articleList, CONNECTION_ERROR))
            is ClientRequestException -> emit(Error(articleList, NO_INTERNET))
            is JsonConvertException -> emit(Error(articleList, SERIALIZATION_ERROR))
            else -> emit(Error(articleList, UNKNOWN))
        }
    }
}