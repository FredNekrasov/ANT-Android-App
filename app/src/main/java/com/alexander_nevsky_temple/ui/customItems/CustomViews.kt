package com.alexander_nevsky_temple.ui.customItems

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.alexander_nevsky_temple.ui.navigation.TitleStrings
import com.alexander_nevsky_temple.ui.utils.DataStrings

@Composable
fun FredText(text: String,modifier: Modifier = Modifier) {
    Text(text,modifier,fontFamily = FontFamily.Serif)
}
@Composable
fun FredTitle(text: String,modifier: Modifier = Modifier) {
    Text(text,modifier,fontSize = MaterialTheme.typography.headlineMedium.fontSize, fontFamily = FontFamily.Serif)
}
@Composable
fun FredIconButton(onClick: Action,icon: ImageVector,contentDescription: String) {
    IconButton(onClick) {
        Icon(icon,contentDescription)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FredTopAppBar(openDrawer: Action) {
    TopAppBar(
        title = { FredText(TitleStrings.MAIN_TITLE) },
        Modifier.fillMaxWidth(),
        navigationIcon = { FredIconButton(openDrawer,Icons.Outlined.Menu,DataStrings.MENU) },
    )
}
@Composable
fun FredNavigationDrawerItem(
    text: String,
    selected: Boolean,
    onClick: Action,
) {
    NavigationDrawerItem(
        label = { FredText(text) },
        selected,
        onClick,
        Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium
    )
}
@Composable
fun FredFloatingActionButton(onClick: Action,icon: ImageVector,contentDescription: String) {
    FloatingActionButton(onClick) {
        Icon(icon,contentDescription)
    }
}
@Composable
fun FredCard(
    onClick: Action,
    image: ComposeFun,
    title: String,
    date: String
) {
    Card(
        onClick,
        Modifier.fillMaxWidth().border(2.dp,Color.Black),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.outlinedCardColors()
    ) {
        image()
        Spacer(Modifier.height(4.dp))
        FredTitle(title)
        Spacer(Modifier.height(4.dp))
        FredText(date)
    }
}