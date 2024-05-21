package com.alexander_nevsky_temple.presentation.screens

import android.content.Intent
import android.widget.TextView
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
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
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
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
fun Contacts(vm: ArticleVM, openWebsite: SAction, openSomeApp: SSAction) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
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
            }, Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(8.dp))
            ContactsCard(contentList = it.content,openWebsite, openSomeApp)
        }
    }
}
@Composable
private fun ContactsCard(contentList: List<String>, openWebsite: SAction, openSomeApp: SSAction) {
    val ftbModifier = Modifier.wrapContentSize().border(1.dp, MaterialTheme.colorScheme.onBackground)
    Row(Modifier.fillMaxWidth().wrapContentHeight(), Arrangement.SpaceEvenly, Alignment.CenterVertically) {
        FredTButton({ openWebsite(contentList.getNotNull(0)) }, Strings.TELEGRAM, ftbModifier)
        FredTButton({ openWebsite(contentList.getNotNull(1)) }, Strings.VK, ftbModifier)
        FredTButton({ openSomeApp(Intent.ACTION_DIAL, contentList.getNotNull(2)) }, Strings.PHONE, ftbModifier)
        FredTButton({ openSomeApp(Intent.ACTION_VIEW, contentList.getNotNull(3)) }, Strings.EMAIL, ftbModifier)
    }
}
@Composable
fun Volunteerism(vm: ArticleVM) {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp)) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Strings.VOLUNTEERISM) return@forEach
            ListItemDetails(article = it, Modifier.fillMaxWidth())
        }
    }
}