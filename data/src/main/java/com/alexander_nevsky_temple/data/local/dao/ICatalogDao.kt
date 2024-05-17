package com.alexander_nevsky_temple.data.local.dao

import androidx.room.*
import com.alexander_nevsky_temple.data.local.entities.Catalog

@Dao
interface ICatalogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(catalog : Catalog)
    @Query("SELECT * FROM Catalogs")
    suspend fun getAll() : List<Catalog>
}