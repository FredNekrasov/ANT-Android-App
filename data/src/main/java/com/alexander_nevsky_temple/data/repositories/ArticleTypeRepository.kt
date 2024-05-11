package com.alexander_nevsky_temple.data.repositories

import com.alexander_nevsky_temple.data.mappers.toModel
import com.alexander_nevsky_temple.data.remote.services.IArticleTypeService
import com.alexander_nevsky_temple.domain.model.ArticleType
import com.alexander_nevsky_temple.domain.repositories.IRepository
import com.alexander_nevsky_temple.domain.utils.ActionStatus.*
import com.alexander_nevsky_temple.domain.utils.*
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus.*
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException
import java.io.IOException

class ArticleTypeRepository(
    private val service: IArticleTypeService
) : IRepository<ArticleType> {
    override suspend fun getList() : StateFlow<ActionStatus<ArticleType>> {
        val data = MutableStateFlow<ActionStatus<ArticleType>>(Loading(emptyList()))
        try {
            val list = service.getArticleTypeList() ?: throw NullPointerException()
            data.emit(Success(list.map { it.toModel() }))
        } catch (e: NullPointerException) {
            data.emit(Error(emptyList(), NO_DATA))
        } catch (e: HttpException) {
            data.emit(Error(emptyList(), CONNECTION_ERROR))
        } catch (e: IOException) {
            data.emit(Error(emptyList(), NO_INTERNET))
        } catch (e: JsonSyntaxException) {
            data.emit(Error(emptyList(), SERIALIZATION_ERROR))
        } catch (e: Exception) {
            data.emit(Error(emptyList(), UNKNOWN))
        }
        return data
    }
}