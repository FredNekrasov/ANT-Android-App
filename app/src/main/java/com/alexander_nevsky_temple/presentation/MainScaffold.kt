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
import com.alexander_nevsky_temple.domain.model.ArticleType
import com.alexander_nevsky_temple.ui.customItems.*

@Composable
fun MainScaffold(
    controller : NavHostController,
    openDrawer : Action,
    navItems : List<ArticleType>
) {
    val modifier = Modifier.fillMaxSize()
    val currentRoute = controller.currentBackStackEntryAsState().value?.destination?.route
    Scaffold(
        modifier,
        topBar = { FredTopAppBar(openDrawer) },
        floatingActionButton = { if(currentRoute != navItems[3].type) FredFloatingActionButton({ controller.navigate(navItems[3].type) }, Icons.Outlined.CalendarMonth, navItems[3].type) },
        floatingActionButtonPosition = FabPosition.End
    ) { padding ->
        MainNavHost(
            controller,
            navItems,
            modifier.padding(padding)
        )
    }
}