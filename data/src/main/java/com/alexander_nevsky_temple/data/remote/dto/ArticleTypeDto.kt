package com.alexander_nevsky_temple.data.remote.dto

import kotlinx.serialization.Serializable

/**
 * The data transfer object for article types received from the server
 * @param id is a unique id of the article type
 * @param name is a name of the article type
 */
@Serializable
data class ArticleTypeDto(
    val id: Int,
    val name: String
)