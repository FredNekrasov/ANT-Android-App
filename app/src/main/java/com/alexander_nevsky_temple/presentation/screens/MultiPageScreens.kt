package com.alexander_nevsky_temple.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.alexander_nevsky_temple.presentation.screens.components.ContentList
import com.alexander_nevsky_temple.presentation.viewModels.ArticleVM
import com.alexander_nevsky_temple.ui.customItems.Info

@Composable
fun ParishLife(vm: ArticleVM) {
    val state = vm.articlesSF.collectAsState().value
    ContentList(state) { it.articleType == Info.PARISH_LIFE }
}
@Composable
fun YouthClub(vm: ArticleVM) {
    val state = vm.articlesSF.collectAsState().value
    ContentList(state) { it.articleType == Info.YOUTH_CLUB }
}
@Composable
fun Advices(vm: ArticleVM) {
    val state = vm.articlesSF.collectAsState().value
    ContentList(state) { it.articleType == Info.ADVICES }
}
@Composable
fun History(vm: ArticleVM) {
    val state = vm.articlesSF.collectAsState().value
    ContentList(state) { it.articleType == Info.HISTORY }
}