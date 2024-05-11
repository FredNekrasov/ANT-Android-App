package com.alexander_nevsky_temple.di.domain

import com.alexander_nevsky_temple.di.utils.DIStrings
import com.alexander_nevsky_temple.domain.useCases.article.GetArticlesUseCase
import com.alexander_nevsky_temple.domain.useCases.articleType.GetArticleTypesUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {
    factory(qualifier = named(DIStrings.ARTICLE + DIStrings.USE_CASE)) {
        GetArticlesUseCase(get(named(DIStrings.ARTICLE + DIStrings.REPOSITORY)))
    }
    factory(qualifier = named(DIStrings.ARTICLE_TYPE + DIStrings.USE_CASE)) {
        GetArticleTypesUseCase(get(named(DIStrings.ARTICLE_TYPE + DIStrings.REPOSITORY)))
    }
}