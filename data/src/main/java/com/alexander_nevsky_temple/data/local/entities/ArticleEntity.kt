package com.alexander_nevsky_temple.data.local.entities

import androidx.room.*

/**
 * This class represents an article in the database with the following parameters:
 *  @param title article title
 *  @param description article description
 *  @param dateOrBanner is the date or the banner of the article
 *  @param catalog is the type of the article
 *  @param content is in the form of a list of links to images or contact information converted to a single string
 *  @param id is the ID of the article in the database that will be used as the primary key
 */
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