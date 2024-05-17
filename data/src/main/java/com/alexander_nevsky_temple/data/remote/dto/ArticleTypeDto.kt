package com.alexander_nevsky_temple.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ArticleTypeDto(
    val id: Int,
    val name: String
)