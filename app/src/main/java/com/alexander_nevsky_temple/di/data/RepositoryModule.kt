package com.alexander_nevsky_temple.di.data

import com.alexander_nevsky_temple.data.repositories.*
import com.alexander_nevsky_temple.di.utils.DIStrings
import com.alexander_nevsky_temple.domain.model.*
import com.alexander_nevsky_temple.domain.repositories.IRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    single<IRepository<ArticleType>>(qualifier = named(DIStrings.ARTICLE_TYPE + DIStrings.REPOSITORY)) {
        ArticleTypeRepository(get(named(DIStrings.ARTICLE_TYPE + DIStrings.SERVICE)))
    }
    single<IRepository<Article>>(qualifier = named(DIStrings.ARTICLE + DIStrings.REPOSITORY)) {
        ArticleRepository(get(named(DIStrings.ARTICLE + DIStrings.SERVICE)))
    }
}