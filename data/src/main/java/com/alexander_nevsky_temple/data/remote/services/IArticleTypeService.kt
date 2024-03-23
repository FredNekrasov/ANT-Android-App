package com.alexander_nevsky_temple.data.remote.services

import com.alexander_nevsky_temple.data.remote.dto.ArticleTypeDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IArticleTypeService {
    @GET("/api/ArticleType")
    suspend fun getDtoList(): List<ArticleTypeDto>?
    companion object {
        fun getService(url: String) : IArticleTypeService = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IArticleTypeService::class.java)
    }
}