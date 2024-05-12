package com.alexander_nevsky_temple.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.alexander_nevsky_temple.domain.model.ArticleType
import com.alexander_nevsky_temple.ui.customItems.FredNavigationDrawerItem
import kotlinx.coroutines.launch

@Composable
fun MainEntryPoint(navItems : List<ArticleType>) {
    val controller = rememberNavController()
    val drawerState = rememberDrawerState(Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(16.dp))
                navItems.forEachIndexed { index, item ->
                    FredNavigationDrawerItem(
                        text = item.type,
                        selected = index == selectedItemIndex,
                        onClick = {
                            controller.navigate(item.type)
                            selectedItemIndex = index
                            scope.launch { drawerState.close() }
                        }
                    )
                }
            }
        }, drawerState = drawerState) {
        MainScaffold(scope, controller, { scope.launch { drawerState.open() } }, navItems)
    }
}