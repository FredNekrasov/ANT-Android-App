package com.alexander_nevsky_temple.data.local.dao

import androidx.room.*
import com.alexander_nevsky_temple.data.local.entities.ArticleEntity

@Dao
interface IArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article : ArticleEntity)
    @Query("SELECT * FROM Articles")
    suspend fun getAll() : List<ArticleEntity>
}