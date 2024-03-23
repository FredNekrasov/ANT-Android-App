package com.alexander_nevsky_temple.data.remote.services

import com.alexander_nevsky_temple.data.remote.dto.ArticleDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IArticleService {
    @GET("/api/Article")
    suspend fun getDtoList(): List<ArticleDto>?
    companion object {
        fun getService(url: String) : IArticleService = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IArticleService::class.java)
    }
}