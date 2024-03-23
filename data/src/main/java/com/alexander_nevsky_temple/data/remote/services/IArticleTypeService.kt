package com.alexander_nevsky_temple.data.remote.services

import com.alexander_nevsky_temple.data.remote.dto.ArticleTypeDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IArticleTypeService {
    @GET("/api/ArticleType")
    suspend fun getDtoList(): List<ArticleTypeDto>?
    companion object {
        private const val BASE_URL = "http://localhost:port"
        fun retrofit() : Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}