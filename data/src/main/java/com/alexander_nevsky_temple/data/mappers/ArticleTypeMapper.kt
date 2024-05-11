package com.alexander_nevsky_temple.data.mappers

import com.alexander_nevsky_temple.data.remote.dto.ArticleTypeDto
import com.alexander_nevsky_temple.domain.model.ArticleType

fun ArticleTypeDto.toModel() = ArticleType(name, id)