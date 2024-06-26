package com.alexander_nevsky_temple.data.di

import androidx.room.Room
import com.alexander_nevsky_temple.data.di.utils.DIStrings
import com.alexander_nevsky_temple.data.local.ANTDb
import com.alexander_nevsky_temple.data.remote.services.ANTClient
import com.alexander_nevsky_temple.data.repositories.*
import com.alexander_nevsky_temple.domain.repositories.IArticleRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * DI module for data layer.
 *  - Database (ANTDb) is created on application start and is used by all repositories.
 *  - Client (ANTClient) is created on application start and is used by all repositories.
 *  - Repository (IArticleRepository) is used by use cases.
 *
 *  @see ANTDb
 *  @see ANTClient
 *  @see IArticleRepository
 *  @see ArticleRepository
 */
val dataModule = module {
    single(qualifier = named(DIStrings.DATABASE), createdAtStart = true) {
        Room.databaseBuilder(get(), ANTDb::class.java, ANTDb.DB_NAME).build()
    }
    single(named(DIStrings.CLIENT), createdAtStart = true) { ANTClient.client }
    single<IArticleRepository>(qualifier = named(DIStrings.ARTICLE + DIStrings.REPOSITORY)) {
        ArticleRepository(
            get<ANTDb>(named(DIStrings.DATABASE)).articleDao(),
            get(named(DIStrings.CLIENT))
        )
    }
}