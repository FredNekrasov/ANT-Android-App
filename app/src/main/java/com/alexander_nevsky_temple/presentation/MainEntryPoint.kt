package com.alexander_nevsky_temple.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.alexander_nevsky_temple.ui.customItems.FredNavigationDrawerItem
import kotlinx.coroutines.launch

@Composable
fun MainEntryPoint(navItems: List<String>) {
    val controller = rememberNavController()
    val drawerState = rememberDrawerState(Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(16.dp))
                navItems.forEachIndexed { index, route ->
                    FredNavigationDrawerItem(
                        text = route,
                        selected = index == selectedItemIndex,
                        onClick = {
                            controller.navigate(route)
                            selectedItemIndex = index
                            scope.launch { drawerState.close() }
                        }
                    )
                }
            }
        }, drawerState = drawerState) {
        MainScaffold(controller, { scope.launch { drawerState.open() } }, navItems)
    }
}