package com.alexander_nevsky_temple.data.repositories

import com.alexander_nevsky_temple.data.mappers.toModel
import com.alexander_nevsky_temple.data.remote.services.IArticleService
import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.repositories.IRepository
import com.alexander_nevsky_temple.domain.utils.*
import com.alexander_nevsky_temple.domain.utils.ActionStatus.*
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus.*
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import java.io.IOException

class ArticleRepository(
    private val service : IArticleService
) : IRepository<Article> {
    override fun getList() : Flow<ActionStatus<Article>> = flow {
        emit(Loading(emptyList()))
        try {
            val contentDtoList = service.getContentList()
            val articleDtoList = service.getArticleList()
            when {
                contentDtoList.isEmpty() || articleDtoList.isEmpty() -> emit(Error(emptyList(), NO_DATA))
                else -> {
                    val articles = articleDtoList.map {
                        val content = contentDtoList.filter { content -> content.articleId == it.id }.map { content -> content.data }
                        it.toModel(content)
                    }
                    emit(Success(articles))
                }
            }
        } catch (e: HttpException) {
            emit(Error(emptyList(), CONNECTION_ERROR))
        } catch (e: IOException) {
            emit(Error(emptyList(), NO_INTERNET))
        } catch (e: JsonSyntaxException) {
            emit(Error(emptyList(), SERIALIZATION_ERROR))
        } catch (e: Exception) {
            emit(Error(emptyList(), UNKNOWN))
        }
    }
}