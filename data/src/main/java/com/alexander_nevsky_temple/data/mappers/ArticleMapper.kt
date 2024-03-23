package com.alexander_nevsky_temple.data.mappers

import com.alexander_nevsky_temple.data.remote.dto.ArticleDto
import com.alexander_nevsky_temple.domain.model.Article

fun ArticleDto.toModel() = Article(
    title,
    description,
    date,
    articleType.toModel(),
    images
)