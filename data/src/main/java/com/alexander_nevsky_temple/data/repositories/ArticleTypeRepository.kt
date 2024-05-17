package com.alexander_nevsky_temple.data.repositories

import com.alexander_nevsky_temple.data.local.dao.ICatalogDao
import com.alexander_nevsky_temple.data.mappers.toEntity
import com.alexander_nevsky_temple.data.mappers.toModel
import com.alexander_nevsky_temple.data.remote.dto.ArticleTypeDto
import com.alexander_nevsky_temple.domain.model.ArticleType
import com.alexander_nevsky_temple.domain.repositories.IRepository
import com.alexander_nevsky_temple.domain.utils.ActionStatus.*
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus.*
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.*
import io.ktor.client.request.get
import kotlinx.coroutines.flow.*
import org.json.JSONException

class ArticleTypeRepository(
    private val catalogDao: ICatalogDao,
    private val client: HttpClient
) : IRepository<ArticleType> {
    override fun getList() : Flow<ActionStatus<ArticleType>> = flow {
        val articleTypes = catalogDao.getAll().map { it.toModel() }
        emit(Loading(articleTypes))
        val catalogs = client.get("/api/v2/catalog").body<List<ArticleTypeDto>?>() ?: emptyList()
        if(catalogs.isEmpty()) emit(Error(articleTypes, NO_DATA))
        else {
            catalogs.forEach { catalogDao.insert(it.toEntity()) }
            emit(Success(catalogs.map { it.toModel() }))
        }
    }.catch { ex ->
        val articleTypes = catalogDao.getAll().map { it.toModel() }
        when(ex) {
            is ServerResponseException -> emit(Error(articleTypes, CONNECTION_ERROR))
            is ClientRequestException -> emit(Error(articleTypes, NO_INTERNET))
            is JSONException -> emit(Error(articleTypes, SERIALIZATION_ERROR))
            else -> emit(Error(articleTypes, UNKNOWN))
        }
    }
}