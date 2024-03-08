package com.alexander_nevsky_temple.ui.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.alexander_nevsky_temple.ui.customItems.*
import com.alexander_nevsky_temple.ui.navigation.ScreenRoute
import com.alexander_nevsky_temple.ui.navigation.TitleStrings.INFORMATION

@Composable
fun MainScaffold(controller: NavController, openDrawer: Action) {
    val modifier = Modifier.fillMaxSize()
    Scaffold(
        modifier,
        topBar = { FredTopAppBar(openDrawer) },
        floatingActionButton = { FredFloatingActionButton({ controller.navigate(ScreenRoute.Information.route) },Icons.Outlined.Info, INFORMATION) },
        floatingActionButtonPosition = FabPosition.End
    ) { padding ->
        modifier.padding(padding)
    }
}