package com.alexander_nevsky_temple.data.repositories

import com.alexander_nevsky_temple.data.local.dao.IArticleDao
import com.alexander_nevsky_temple.data.mappers.toEntity
import com.alexander_nevsky_temple.data.mappers.toModel
import com.alexander_nevsky_temple.data.remote.dto.ArticleDto
import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.repositories.IArticleRepository
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import com.alexander_nevsky_temple.domain.utils.ActionStatus.*
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus.*
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import kotlinx.coroutines.flow.*
import org.json.JSONException

class ArticleRepository(
    private val articleDao: IArticleDao,
    private val client: HttpClient
) : IArticleRepository {
    override fun getList(type: String) : Flow<ActionStatus<Article>> = flow {
        val articleList = articleDao.getAll().map { it.toModel() }
        emit(Loading(articleList))
        if(articleList.isEmpty()) {
            val articleDtoList = client.get("/api/v1/chapter?type=$type").body<List<ArticleDto>?>() ?: emptyList()
            if(articleDtoList.isEmpty()) emit(Error(articleList, NO_DATA))
            else {
                articleDtoList.forEach { articleDao.insert(it.toEntity()) }
                emit(Success(articleDtoList.map { it.toModel() }))
            }
        }
    }.catch { ex ->
        val articleList = articleDao.getAll().map { it.toModel() }
        when(ex) {
            is ServerResponseException -> emit(Error(articleList, CONNECTION_ERROR))
            is ClientRequestException -> emit(Error(articleList, NO_INTERNET))
            is JSONException -> emit(Error(articleList, SERIALIZATION_ERROR))
            else -> emit(Error(articleList, UNKNOWN))
        }
    }
}