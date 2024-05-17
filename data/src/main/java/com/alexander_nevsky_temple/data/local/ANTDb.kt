package com.alexander_nevsky_temple.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexander_nevsky_temple.data.local.dao.*
import com.alexander_nevsky_temple.data.local.entities.*

@Database(
    entities = [Catalog::class, ArticleEntity::class],
    version = 2,
    exportSchema = false
)
abstract class ANTDb : RoomDatabase() {
    abstract fun catalogDao() : ICatalogDao
    abstract fun articleDao() : IArticleDao
    companion object {
        const val DB_NAME = "ant.db"
    }
}