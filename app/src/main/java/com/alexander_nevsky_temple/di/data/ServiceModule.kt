package com.alexander_nevsky_temple.di.data

import com.alexander_nevsky_temple.data.remote.services.IArticleService
import com.alexander_nevsky_temple.data.remote.services.IArticleTypeService
import com.alexander_nevsky_temple.di.utils.DIStrings
import org.koin.core.qualifier.named
import org.koin.dsl.module

val serviceModule = module {
    single<IArticleTypeService>(
        qualifier = named(DIStrings.ARTICLE_TYPE + DIStrings.SERVICE),
        createdAtStart = true
    ) {
        IArticleTypeService.retrofit().create(IArticleTypeService::class.java)
    }
    single<IArticleService>(
        qualifier = named(DIStrings.ARTICLE + DIStrings.SERVICE),
        createdAtStart = true
    ) {
        IArticleTypeService.retrofit().create(IArticleService::class.java)
    }
}