package com.alexander_nevsky_temple.data.mappers

import com.alexander_nevsky_temple.data.remote.dto.ArticleDto
import com.alexander_nevsky_temple.domain.model.Article

fun ArticleDto.toModel(content: List<String>) = Article(
    title,
    description,
    dateOrBanner,
    catalog.toModel(),
    content
)