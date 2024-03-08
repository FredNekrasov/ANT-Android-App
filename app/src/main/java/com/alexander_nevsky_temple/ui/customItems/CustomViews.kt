package com.alexander_nevsky_temple.ui.customItems

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import com.alexander_nevsky_temple.ui.navigation.TitleStrings
import com.alexander_nevsky_temple.ui.utils.DataStrings

@Composable
fun FredButton(
    onClick: Action,
    text: String,
    buttonColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    Button(onClick, colors = ButtonDefaults.buttonColors(buttonColor)) {
        FredText(text,textColor)
    }
}
@Composable
fun FredText(
    text: String,
    textColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    Text(text,color = textColor,fontFamily = FontFamily.Serif)
}
@Composable
fun FredTitle(
    text: String,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
) {
    Text(text,color = textColor, fontSize = MaterialTheme.typography.headlineMedium.fontSize, fontFamily = FontFamily.Serif)
}
@Composable
fun FredIconButton(
    onClick: Action,
    iconColor: Color = MaterialTheme.colorScheme.primary,
    icon: ImageVector,
    contentDescription: String
    ) {
    IconButton(onClick, colors = IconButtonDefaults.iconButtonColors(iconColor)) {
        Icon(icon,contentDescription)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FredTopAppBar(
    titleColor: Color,
    openDrawer: Action,
    iconColor: Color = MaterialTheme.colorScheme.background,
    mainColor: Color = MaterialTheme.colorScheme.onBackground
) {
    TopAppBar(
        title = { FredTitle(TitleStrings.MAIN_TITLE,titleColor) },
        Modifier.fillMaxWidth(),
        navigationIcon = { FredIconButton(openDrawer,iconColor,Icons.Outlined.Menu,DataStrings.MENU) },
        colors = TopAppBarDefaults.topAppBarColors(mainColor)
    )
}