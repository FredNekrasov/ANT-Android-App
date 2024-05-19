package com.alexander_nevsky_temple.presentation.screens

import android.widget.TextView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.alexander_nevsky_temple.R
import com.alexander_nevsky_temple.presentation.screens.components.ListItemDetails
import com.alexander_nevsky_temple.presentation.viewModels.ArticleVM
import com.alexander_nevsky_temple.ui.customItems.*

@Composable
fun MainScreen(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp)) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Strings.MAIN) return@forEach
            ListItemDetails(it, Modifier.fillMaxWidth())
        }
    }
}
@Composable
fun Priesthood(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp)) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Strings.PRIESTHOOD) return@forEach
            ListItemDetails(it, Modifier.fillMaxWidth())
        }
    }
}
@Composable
fun Schedule(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), Arrangement.Center) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Strings.SCHEDULE) return@forEach
            AsyncImage(model = it.title.toUri(), contentDescription = it.title, modifier = Modifier.fillMaxWidth())
        }
    }
}
@Composable
fun Sacraments(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp), Arrangement.Center) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Strings.SACRAMENTS) return@forEach
            FredTitle(text = it.title)
            Spacer(modifier = Modifier.height(8.dp))
            FredText(text = it.description, modifier = Modifier.fillMaxWidth(), TextAlign.Center)
        }
    }
}
@Composable
fun Contacts(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp)) {
        val state = vm.articlesSF.collectAsState().value
        state.list.forEach {
            if(it.articleType != Strings.CONTACTS) return@forEach
            AndroidView(factory = { context ->
                if(state.status.isError()) context.displayMessage(state.status.getMessage())
                TextView(context).apply {
                    text = it.title
                    textSize = 24f
                    setTextColor(resources.getColor(R.color.black, null))
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }
            }, Modifier.fillMaxWidth().align(Alignment.CenterHorizontally))
        }
    }
}
@Composable
fun Volunteerism(vm: ArticleVM) {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp)) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Strings.VOLUNTEERISM) return@forEach
            ListItemDetails(article = it)
        }
    }
}