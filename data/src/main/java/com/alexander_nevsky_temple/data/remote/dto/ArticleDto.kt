package com.alexander_nevsky_temple.data.remote.dto

data class ArticleDto(
    val id: Long,
    val title: String,
    val description: String,
    val dateOrBanner: String,
    val catalog: ArticleTypeDto,
)