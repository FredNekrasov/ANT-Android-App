package com.alexander_nevsky_temple.data.remote.services

import com.alexander_nevsky_temple.data.remote.dto.ArticleTypeDto
import retrofit2.http.GET

interface IArticleTypeService {
    @GET("/api/v2/catalog")
    suspend fun getArticleTypeList(): List<ArticleTypeDto>
}