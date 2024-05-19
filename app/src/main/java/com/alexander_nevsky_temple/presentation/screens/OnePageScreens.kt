package com.alexander_nevsky_temple.presentation.screens

import android.widget.TextView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.alexander_nevsky_temple.R
import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.presentation.screens.components.*
import com.alexander_nevsky_temple.presentation.viewModels.ArticleVM
import com.alexander_nevsky_temple.ui.customItems.*

@Composable
fun MainScreen(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp)) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Strings.MAIN) return@forEach
            ListItem(it, Modifier.wrapContentSize())
        }
    }
}
@Composable
fun Priesthood(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp)) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Strings.PRIESTHOOD) return@forEach
            ListItem(it, Modifier.wrapContentSize())
        }
    }
}
@Composable
fun Schedule(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Strings.SCHEDULE) return@forEach
            AsyncImage(model = it.title.toUri(), contentDescription = it.title, modifier = Modifier.fillMaxWidth())
        }
    }
}
@Composable
fun Sacraments(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp), Arrangement.Top, Alignment.CenterHorizontally) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Strings.SACRAMENTS) return@forEach
            FredTitle(text = it.title)
            FredText(text = it.description, modifier = Modifier.wrapContentSize())
        }
    }
}
@Composable
fun Contacts(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp), Arrangement.Top, Alignment.CenterHorizontally) {
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
            }, Modifier.wrapContentSize())
        }
    }
}
@Composable
fun Volunteerism(vm: ArticleVM) {
    vm.articlesSF.collectAsState().value.list.forEach {
        if(it.articleType != Strings.VOLUNTEERISM) return@forEach
        VolunteerismCard(it)
    }
}
@Composable
private fun VolunteerismCard(it: Article, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FredTitle(it.title)
        Spacer(Modifier.height(8.dp))
        FredText(it.description)
        Spacer(Modifier.height(8.dp))
        ImageSlider(article = it, Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
    }
}