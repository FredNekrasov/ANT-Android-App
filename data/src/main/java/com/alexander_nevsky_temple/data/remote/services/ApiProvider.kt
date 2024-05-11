package com.alexander_nevsky_temple.data.remote.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private fun getRetrofit(
    url: String = "http://localhost:8080"
): Retrofit = Retrofit.Builder()
    .baseUrl(url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
fun getArticleService(): IArticleService = getRetrofit().create(IArticleService::class.java)
fun getArticleTypeService(): IArticleTypeService = getRetrofit().create(IArticleTypeService::class.java)