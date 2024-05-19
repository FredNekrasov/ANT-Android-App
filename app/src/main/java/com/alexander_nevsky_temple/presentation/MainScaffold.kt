package com.alexander_nevsky_temple.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alexander_nevsky_temple.ui.customItems.*

@Composable
fun MainScaffold(
    controller: NavHostController,
    openDrawer: () -> Unit,
    navItems: List<String>
) {
    val modifier = Modifier.fillMaxSize()
    val currentRoute = controller.currentBackStackEntryAsState().value?.destination?.route
    Scaffold(
        modifier,
        topBar = { FredTopAppBar(openDrawer) },
        floatingActionButton = { if(currentRoute != navItems[2]) FredFloatingActionButton({ controller.navigate(navItems[2]) }, Icons.Outlined.CalendarMonth) },
        floatingActionButtonPosition = FabPosition.End
    ) { padding ->
        MainNavHost(controller, navItems, modifier.padding(padding))
    }
}