package com.alexander_nevsky_temple.data.repositories

import com.alexander_nevsky_temple.data.mappers.toModel
import com.alexander_nevsky_temple.data.remote.services.IArticleTypeService
import com.alexander_nevsky_temple.domain.model.ArticleType
import com.alexander_nevsky_temple.domain.repositories.IRepository
import com.alexander_nevsky_temple.domain.utils.ActionStatus.*
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus.*
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import java.io.IOException

class ArticleTypeRepository(
    private val service: IArticleTypeService
) : IRepository<ArticleType> {
    override fun getList() : Flow<ActionStatus<ArticleType>> = flow {
        emit(Loading(emptyList()))
        try {
            val list = service.getArticleTypeList()
            when {
                list.isEmpty() -> emit(Error(emptyList(), NO_DATA))
                else -> emit(Success(list.map { it.toModel() }))
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