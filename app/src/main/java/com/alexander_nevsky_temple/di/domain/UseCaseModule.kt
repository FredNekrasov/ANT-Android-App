package com.alexander_nevsky_temple.di.domain

import com.alexander_nevsky_temple.di.utils.DIStrings
import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.model.ArticleType
import com.alexander_nevsky_temple.domain.repositories.IRepository
import com.alexander_nevsky_temple.domain.useCases.IGetListUseCase
import com.alexander_nevsky_temple.domain.useCases.implementation.article.GetArticlesUseCase
import com.alexander_nevsky_temple.domain.useCases.implementation.articleType.GetArticleTypesUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {
    factory<IGetListUseCase<Article>>(qualifier = named(DIStrings.ARTICLE + DIStrings.USE_CASE)) {
        GetArticlesUseCase(get<IRepository<Article>>(named(DIStrings.ARTICLE + DIStrings.REPOSITORY)))
    }
    factory<IGetListUseCase<ArticleType>>(qualifier = named(DIStrings.ARTICLE_TYPE + DIStrings.USE_CASE)) {
        GetArticleTypesUseCase(get<IRepository<ArticleType>>(named(DIStrings.ARTICLE_TYPE + DIStrings.REPOSITORY)))
    }
}