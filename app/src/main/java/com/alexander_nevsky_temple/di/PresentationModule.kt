package com.alexander_nevsky_temple.di

import com.alexander_nevsky_temple.data.di.utils.DIStrings
import com.alexander_nevsky_temple.presentation.viewModels.ArticleVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val vmModule = module {
    viewModel(qualifier(DIStrings.ARTICLE + DIStrings.VIEWMODEL)) {
        ArticleVM(get(named(DIStrings.ARTICLE + DIStrings.USE_CASE)))
    }
}