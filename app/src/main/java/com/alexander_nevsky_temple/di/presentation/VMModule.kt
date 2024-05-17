package com.alexander_nevsky_temple.di.presentation

import com.alexander_nevsky_temple.data.di.utils.DIStrings
import com.alexander_nevsky_temple.presentation.viewModels.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val vmModule = module {
    viewModel<ArticleVM>(qualifier = named(DIStrings.VIEWMODEL + DIStrings.ARTICLE)) {
        ArticleVM(get(named(DIStrings.ARTICLE + DIStrings.USE_CASE)))
    }
    viewModel<ArticleTypeVM>(qualifier = named(DIStrings.VIEWMODEL + DIStrings.ARTICLE_TYPE)) {
        ArticleTypeVM(get(named(DIStrings.ARTICLE_TYPE + DIStrings.USE_CASE)))
    }
}