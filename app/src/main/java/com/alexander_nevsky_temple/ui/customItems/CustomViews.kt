package com.alexander_nevsky_temple.ui.customItems

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import com.alexander_nevsky_temple.ui.navigation.TitleStrings
import com.alexander_nevsky_temple.ui.utils.DataStrings

@Composable
fun FredButton(onClick: Action,text: String) {
    Button(onClick) {
        FredText(text)
    }
}
@Composable
fun FredText(text: String) {
    Text(text,fontFamily = FontFamily.Serif)
}
@Composable
fun FredTitle(text: String) {
    Text(text,fontSize = MaterialTheme.typography.headlineMedium.fontSize, fontFamily = FontFamily.Serif)
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
        title = { FredTitle(TitleStrings.MAIN_TITLE) },
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