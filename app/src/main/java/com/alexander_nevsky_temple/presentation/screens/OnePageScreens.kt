package com.alexander_nevsky_temple.presentation.screens

import android.widget.TextView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.alexander_nevsky_temple.R
import com.alexander_nevsky_temple.presentation.screens.components.ListItemDetails
import com.alexander_nevsky_temple.presentation.viewModels.ArticleVM
import com.alexander_nevsky_temple.ui.customItems.*

@Composable
fun MainScreen(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp)) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Info.MAIN) return@forEach
            ListItemDetails(it, Modifier.fillMaxWidth())
        }
    }
}
@Composable
fun Priesthood(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp)) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Info.PRIESTHOOD) return@forEach
            ListItemDetails(it, Modifier.fillMaxWidth())
        }
    }
}
@Composable
fun Schedule(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Info.SCHEDULE) return@forEach
            AsyncImage(model = it.title, contentDescription = it.title, modifier = Modifier.fillMaxWidth())
            AsyncImage(model = it.description, contentDescription = it.description, modifier = Modifier.fillMaxWidth())
        }
    }
}
@Composable
fun Sacraments(vm: ArticleVM) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp), Arrangement.Center) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Info.SACRAMENTS) return@forEach
            FredTitle(text = it.title)
            Spacer(modifier = Modifier.height(8.dp))
            FredText(text = it.description, modifier = Modifier.fillMaxWidth(), TextAlign.Center)
        }
    }
}
/**
 *   Contacts screen with buttons for phone, telegram, vk, email.
 *   AndroidView is used to check status of the state and display the error message
 *
 *   @param openSomeApp action for opening some app
 *   @param vm ArticleVM
 */
@Composable
fun Contacts(vm: ArticleVM, openSomeApp: SAction) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        val state = vm.articlesSF.collectAsState().value
        state.list.forEach {
            if(it.articleType != Info.CONTACTS) return@forEach
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
            ContactsCard(contentList = it.content, openSomeApp)
        }
    }
}
/**
 * Contacts card with buttons for phone, telegram, vk, email
 *  @param contentList list of the contact information
 *  @param openSomeApp action for opening app like telegram, vk, email and phone
 */
@Composable
private fun ContactsCard(contentList: List<String>, openSomeApp: SAction) {
    Row(Modifier.fillMaxWidth().wrapContentHeight(), Arrangement.SpaceEvenly, Alignment.CenterVertically) {
        FredIconButton({ openSomeApp(contentList.getNotNull(2)) }, Icons.Default.Phone, Info.PHONE)
        FredTButton({ openSomeApp(contentList.getNotNull(0)) }, Info.TELEGRAM)
        FredTButton({ openSomeApp(contentList.getNotNull(1)) }, Info.VK)
        FredIconButton({ openSomeApp(contentList.getNotNull(3)) }, Icons.Default.MailOutline, Info.EMAIL)
    }
}
@Composable
fun Volunteerism(vm: ArticleVM) {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp)) {
        vm.articlesSF.collectAsState().value.list.forEach {
            if(it.articleType != Info.VOLUNTEERISM) return@forEach
            ListItemDetails(article = it, Modifier.fillMaxWidth())
        }
    }
}