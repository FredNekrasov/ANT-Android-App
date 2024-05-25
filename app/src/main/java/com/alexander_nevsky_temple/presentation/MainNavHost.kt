package com.alexander_nevsky_temple.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexander_nevsky_temple.data.di.utils.DIStrings
import com.alexander_nevsky_temple.presentation.screens.*
import com.alexander_nevsky_temple.presentation.viewModels.ArticleVM
import com.alexander_nevsky_temple.ui.customItems.SAction
import org.koin.androidx.compose.koinViewModel
import org.koin.core.qualifier.qualifier

/**
 * Main navigation host. It is used to navigate between screens in the application.
 *  @param controller is the navigation controller for navigation between screens
 *  @param navItems is a list of navigation items
 *  @param openSomeApp is an action that opens some app
 *  @param modifier is a modifier. By default, it is empty
 *  @param articleVM is an article view model. By default, it is a koin view model with qualifier
 *
 *  @see ArticleVM
 */
@Composable
fun MainNavHost(
    controller: NavHostController,
    navItems: List<String>,
    openSomeApp: SAction,
    modifier: Modifier = Modifier,
    articleVM: ArticleVM = koinViewModel(qualifier(DIStrings.ARTICLE + DIStrings.VIEWMODEL))
) {
    Column(modifier) {
        NavHost(controller, startDestination = navItems[0]) {
            composable(navItems[0]) { MainScreen(articleVM) }
            composable(navItems[1]) { ParishLife(articleVM) }
            composable(navItems[2]) { Schedule(articleVM) }
            composable(navItems[3]) { Box(modifier) { CircularProgressIndicator(Modifier.align(Alignment.Center)) } }
            composable(navItems[4]) { YouthClub(articleVM) }
            composable(navItems[5]) { Priesthood(articleVM) }
            composable(navItems[6]) { Advices(articleVM) }
            composable(navItems[7]) { History(articleVM) }
            composable(navItems[8]) { Sacraments(articleVM) }
            composable(navItems[9]) { Contacts(articleVM, openSomeApp) }
            composable(navItems[10]) { Box(modifier) { LinearProgressIndicator(Modifier.align(Alignment.Center)) } }
            composable(navItems[11]) { Volunteerism(articleVM) }
        }
    }
}