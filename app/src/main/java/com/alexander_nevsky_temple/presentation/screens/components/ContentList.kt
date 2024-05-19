package com.alexander_nevsky_temple.presentation.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.utils.ActionStatus
import com.alexander_nevsky_temple.ui.customItems.FredCard

@Composable
fun ContentList(
    state: ActionStatus<Article>,
    condition: (Article) -> Boolean
) {
    var isShowDialog by rememberSaveable { mutableStateOf(false) }
    var articleIndex by rememberSaveable { mutableIntStateOf(0) }
    LazyColumn(Modifier.fillMaxSize().padding(8.dp)) {
        itemsIndexed(state.list) { index, it ->
            if(!condition(it)) return@itemsIndexed
            FredCard(
                onClick = { articleIndex = index; isShowDialog = true },
                uri = it.content.getOrNull(0),
                title = it.title,
                date = it.date
            )
            Spacer(Modifier.height(4.dp))
        }
    }
    if(isShowDialog) {
        ListItemDialog(isShowDialog = { isShowDialog = it }, article = state.list[articleIndex])
    }
}