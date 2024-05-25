package com.alexander_nevsky_temple.data.mappers

import com.alexander_nevsky_temple.data.local.entities.*
import com.alexander_nevsky_temple.data.remote.dto.ArticleDto
import com.alexander_nevsky_temple.domain.model.Article
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 *  Mapper for mapping ArticleDto to ArticleEntity and vice versa
 *  @return ArticleEntity
 */
fun ArticleDto.toEntity() = ArticleEntity(
    title, description, dateOrBanner, catalog.name, Json.encodeToString(content), id
)
/**
 *  Mapper for mapping ArticleDto to Article and vice versa
 *  @return Article
 */
fun ArticleDto.toModel() = Article(
    title, description, dateOrBanner, catalog.name, content
)
/**
 *  Mapper for mapping ArticleEntity to Article and vice versa
 *  @return Article
 */
fun ArticleEntity.toModel() = Article(
    title, description, dateOrBanner, catalog,
    Json.decodeFromString<List<String>>(content)
)