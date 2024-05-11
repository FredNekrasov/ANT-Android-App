package com.alexander_nevsky_temple.data.remote.services

import com.alexander_nevsky_temple.data.remote.dto.ArticleDto
import com.alexander_nevsky_temple.data.remote.dto.ContentDto
import retrofit2.http.GET

interface IArticleService {
    @GET("/api/Article")
    suspend fun getArticleList(): List<ArticleDto>?
    @GET("/api/Content")
    suspend fun getContentList(): List<ContentDto>?
}