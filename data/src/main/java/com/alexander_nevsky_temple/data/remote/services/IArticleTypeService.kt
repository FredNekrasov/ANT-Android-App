package com.alexander_nevsky_temple.data.remote.services

import com.alexander_nevsky_temple.data.remote.dto.ArticleTypeDto
import retrofit2.http.GET

interface IArticleTypeService {
    @GET("/api/ArticleType")
    suspend fun getArticleTypeList(): List<ArticleTypeDto>?
}