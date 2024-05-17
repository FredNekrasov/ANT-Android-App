package com.alexander_nevsky_temple.data.local.entities

import androidx.room.*

@Entity(tableName = "Articles")
data class ArticleEntity(
    val title: String,
    val description: String,
    val dateOrBanner: String,
    val catalog: String,
    val content: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
)