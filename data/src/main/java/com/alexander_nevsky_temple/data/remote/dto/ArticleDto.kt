package com.alexander_nevsky_temple.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ArticleDto(
    val id: Long,
    val catalog: ArticleTypeDto,
    val title: String,
    val description: String,
    val dateOrBanner: String,
    val content: List<String>
)