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
import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.ui.customItems.FredIconButton

/**
 * Shows the details of the article with a close button.
 *  @param isShowDialog is a function that is called when the close button is clicked
 *  @param article is the article to be shown in the details
 */
@Composable
fun ListItem(
    isShowDialog: (Boolean) -> Unit,
    article: Article
) {
    LazyColumn(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        item { ListItemDetails(article, Modifier.wrapContentSize().padding(8.dp)) }
        item {
            Box(Modifier.fillMaxWidth().wrapContentHeight()) {
                FredIconButton(
                    onClick = { isShowDialog(false) }, icon = Icons.Default.Close, description = article.title,
                    modifier = Modifier.align(Alignment.BottomCenter).padding(8.dp).border(2.dp, MaterialTheme.colorScheme.error, MaterialTheme.shapes.medium)
                )
            }
        }
    }
}