package com.alexander_nevsky_temple.data.mappers

import com.alexander_nevsky_temple.data.local.entities.*
import com.alexander_nevsky_temple.data.remote.dto.ArticleDto
import com.alexander_nevsky_temple.domain.model.Article
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun ArticleDto.toEntity() = ArticleEntity(
    title, description, dateOrBanner, Json.encodeToString(catalog), Json.encodeToString(content), id
)
fun ArticleDto.toModel() = Article(
    title, description, dateOrBanner, catalog.toModel(), content
)
fun ArticleEntity.toModel() = Article(
    title, description, dateOrBanner,
    Json.decodeFromString<Catalog>(catalog).toModel(),
    Json.decodeFromString<List<String>>(content)
)