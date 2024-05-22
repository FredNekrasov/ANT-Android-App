package com.alexander_nevsky_temple.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material3.*
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.alexander_nevsky_temple.ui.customItems.*
import kotlinx.coroutines.launch

@Composable
fun MainEntryPoint(navItems: List<String>, openSomeApp: SAction) {
    val controller = rememberNavController()
    val drawerState = rememberDrawerState(Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    val navigateTo: (Int, String) -> Unit = { index, route ->
        controller.navigate(route)
        selectedItemIndex = index
        scope.launch { drawerState.close() }
    }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(Modifier.fillMaxSize(), Arrangement.Center) {
                    navItems.forEachIndexed { index, route ->
                        FredNavigationDrawerItem(
                            text = route,
                            selected = index == selectedItemIndex,
                            onClick = {
                                when(index) {
                                    3 -> openSomeApp(Info.SPIRITUAL_TALKS_URL)
                                    10 -> openSomeApp(Info.INFORMATION_URL)
                                    else -> navigateTo(index, route)
                                }
                            }
                        )
                        Spacer(Modifier.height(2.dp))
                    }
                }
            }
        }, drawerState = drawerState) {
        val currentRoute = controller.currentBackStackEntryAsState().value?.destination?.route
        Scaffold(
            Modifier.fillMaxSize(),
            topBar = { FredTopAppBar { scope.launch { drawerState.open() } } },
            floatingActionButton = { if(currentRoute != navItems[2]) FredFloatingActionButton({ navigateTo(2, navItems[2]) }, Icons.Outlined.CalendarMonth) },
        ) { padding ->
            MainNavHost(controller, navItems, openSomeApp, Modifier.fillMaxSize().padding(padding))
        }
    }
}