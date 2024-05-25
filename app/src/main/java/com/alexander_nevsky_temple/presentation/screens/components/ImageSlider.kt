package com.alexander_nevsky_temple.presentation.screens.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.alexander_nevsky_temple.domain.model.Article

/**
 *   Composable function that displays list of images
 *   @param article object of [Article]. Contains list of images
 *   @param modifier
 */
@Composable
fun ImageSlider(
    article: Article,
    modifier: Modifier = Modifier
) {
    LazyRow(modifier, horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
        items(article.content) { photo ->
            AsyncImage(model = photo.toUri(), contentDescription = article.title, Modifier.height(300.dp).border(2.dp, MaterialTheme.colorScheme.background))
        }
    }
}