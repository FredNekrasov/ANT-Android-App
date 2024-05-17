package com.alexander_nevsky_temple.data.di

import androidx.room.Room
import com.alexander_nevsky_temple.data.di.utils.DIStrings
import com.alexander_nevsky_temple.data.local.ANTDb
import com.alexander_nevsky_temple.data.remote.services.ANTClient
import com.alexander_nevsky_temple.data.repositories.*
import com.alexander_nevsky_temple.domain.model.*
import com.alexander_nevsky_temple.domain.repositories.IRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    single(qualifier = named(DIStrings.DATABASE), createdAtStart = true) {
        Room.databaseBuilder(get(), ANTDb::class.java, ANTDb.DB_NAME).build()
    }
    single(named(DIStrings.CLIENT), createdAtStart = true) { ANTClient.client }
    single<IRepository<ArticleType>>(qualifier = named(DIStrings.ARTICLE_TYPE + DIStrings.REPOSITORY)) {
        ArticleTypeRepository(
            get<ANTDb>(named(DIStrings.DATABASE)).catalogDao(),
            get(named(DIStrings.CLIENT))
        )
    }
    single<IRepository<Article>>(qualifier = named(DIStrings.ARTICLE + DIStrings.REPOSITORY)) {
        ArticleRepository(
            get<ANTDb>(named(DIStrings.DATABASE)).articleDao(),
            get(named(DIStrings.CLIENT))
        )
    }
}