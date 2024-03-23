package com.alexander_nevsky_temple.data.repositories

import com.alexander_nevsky_temple.data.mappers.toModel
import com.alexander_nevsky_temple.data.remote.services.IArticleService
import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.repositories.IRepository
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus.*
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException
import java.io.IOException

class ArticleRepository(
    private val service : IArticleService
) : IRepository<Article> {
    override suspend fun getList() : StateFlow<ConnectionStatus<Article>> {
        val data = MutableStateFlow<ConnectionStatus<Article>>(Loading(emptyList()))
        try {
            val list = service.getDtoList() ?: throw NullPointerException("No data")
            data.emit(Success(list.map { it.toModel() }))
        } catch (e: NullPointerException) {
            data.emit(NoData(e.message.toString(), emptyList()))
        } catch (e: HttpException) {
            data.emit(ConnectionError(e.message.toString(), emptyList()))
        } catch (e: IOException) {
            data.emit(NoInternet(e.message.toString(), emptyList()))
        } catch (e: JsonSyntaxException) {
            data.emit(SerializationError(e.message.toString(), emptyList()))
        } catch (e: Exception) {
            data.emit(Unknown(e.message.toString(), emptyList()))
        }
        return data
    }
}