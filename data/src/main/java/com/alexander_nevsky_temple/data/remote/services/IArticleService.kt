package com.alexander_nevsky_temple.data.remote.services

import com.alexander_nevsky_temple.data.remote.dto.ArticleDto
import retrofit2.http.GET

interface IArticleService {
    @GET("/api/Article")
    suspend fun getDtoList(): List<ArticleDto>?
}