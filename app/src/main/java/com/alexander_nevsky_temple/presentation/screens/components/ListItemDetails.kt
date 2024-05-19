package com.alexander_nevsky_temple.presentation.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.ui.customItems.FredText
import com.alexander_nevsky_temple.ui.customItems.FredTitle

@Composable
fun ListItemDetails(
    article: Article,
    modifier: Modifier = Modifier
) {
    Column(modifier, Arrangement.Center, Alignment.CenterHorizontally) {
        FredTitle(article.articleType)
        Spacer(Modifier.height(8.dp))
        FredTitle(article.title)
        Spacer(Modifier.height(4.dp))
        if(article.date.isNotBlank()) FredText(article.date, modifier = Modifier.wrapContentSize().align(Alignment.End))
        Spacer(Modifier.height(4.dp))
        ImageSlider(article = article, Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
        FredText(article.description)
    }
}