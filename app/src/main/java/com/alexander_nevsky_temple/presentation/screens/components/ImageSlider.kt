package com.alexander_nevsky_temple.presentation.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.alexander_nevsky_temple.domain.model.Article

@Composable
fun ImageSlider(
    article: Article,
    modifier: Modifier = Modifier
) {
    LazyRow(modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
        items(article.content) { photo ->
            AsyncImage(model = photo.toUri(), contentDescription = article.title, Modifier.height(250.dp))
            Spacer(Modifier.width(8.dp))
        }
    }
}