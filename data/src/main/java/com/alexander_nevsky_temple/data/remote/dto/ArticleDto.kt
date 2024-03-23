package com.alexander_nevsky_temple.data.remote.dto

data class ArticleDto(
    val id: String,
    val title: String,
    val description: String,
    val date: String,
    val articleType: ArticleTypeDto,
    val content: List<String>
)