package com.alexander_nevsky_temple.di.data

import com.alexander_nevsky_temple.data.remote.services.*
import com.alexander_nevsky_temple.di.utils.DIStrings
import org.koin.core.qualifier.named
import org.koin.dsl.module

val serviceModule = module {
    single<IArticleTypeService>(
        qualifier = named(DIStrings.ARTICLE_TYPE + DIStrings.SERVICE),
        createdAtStart = true
    ) {
        getArticleTypeService()
    }
    single<IArticleService>(
        qualifier = named(DIStrings.ARTICLE + DIStrings.SERVICE),
        createdAtStart = true
    ) {
        getArticleService()
    }
}