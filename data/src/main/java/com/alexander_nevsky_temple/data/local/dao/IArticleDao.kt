package com.alexander_nevsky_temple.data.local.dao

import androidx.room.*
import com.alexander_nevsky_temple.data.local.entities.ArticleEntity

/**
 * This interface is used to access data from the database:
 * [insert] is used to insert data into the database or update it if it already exists.
 * [getAll] is used to query data from the database to return a list of objects.
 */
@Dao
interface IArticleDao {
    @Upsert
    suspend fun insert(article : ArticleEntity)
    @Query("SELECT * FROM Articles")
    suspend fun getAll() : List<ArticleEntity>
}