package com.alexander_nevsky_temple.di

import com.alexander_nevsky_temple.data.di.utils.DIStrings
import com.alexander_nevsky_temple.domain.useCases.GetArticlesUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * DI module for domain layer.
 *  - GetArticlesUseCase is used by viewModels.
 *  @see GetArticlesUseCase
 */
val domainModule = module {
    factory(qualifier = named(DIStrings.ARTICLE + DIStrings.USE_CASE)) {
        GetArticlesUseCase(get(named(DIStrings.ARTICLE + DIStrings.REPOSITORY)))
    }
}