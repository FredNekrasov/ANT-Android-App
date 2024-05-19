package com.alexander_nevsky_temple.presentation.screens.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.ui.customItems.FredIconButton

@Composable
fun ListItemDialog(
    isShowDialog: (Boolean) -> Unit,
    article: Article
) {
    Dialog(onDismissRequest = { isShowDialog(false) }) {
        LazyColumn {
            item { ListItem(article, Modifier.fillMaxWidth()) }
            item {
                Box(Modifier.fillMaxWidth()) {
                    FredIconButton(
                        onClick = { isShowDialog(false) }, icon = Icons.Default.Close,
                        description = article.title,
                        modifier = Modifier.align(Alignment.BottomEnd).padding(8.dp).border(2.dp, MaterialTheme.colorScheme.error, MaterialTheme.shapes.medium)
                    )
                }
            }
        }
    }
}