package com.alexander_nevsky_temple.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Catalogs")
data class Catalog(
    val name: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int?  = null
)