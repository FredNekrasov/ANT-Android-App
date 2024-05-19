package com.alexander_nevsky_temple.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexander_nevsky_temple.data.local.dao.*
import com.alexander_nevsky_temple.data.local.entities.*

@Database(
    entities = [ArticleEntity::class],
    version = 4,
    exportSchema = false
)
abstract class ANTDb : RoomDatabase() {
    abstract fun articleDao() : IArticleDao
    companion object {
        const val DB_NAME = "ant.db"
    }
}