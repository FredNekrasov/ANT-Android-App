package com.alexander_nevsky_temple.domain.model

data class Article(
    val title: String,
    val description: String,
    val date: String,
    val articleType: ArticleType,
    val images: List<String>,
    val id: Int? = null
)