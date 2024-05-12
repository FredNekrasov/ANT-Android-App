package com.alexander_nevsky_temple.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexander_nevsky_temple.domain.model.ArticleType

@Composable
fun MainNavHost(
    controller : NavHostController,
    navItems : List<ArticleType>,
    modifier : Modifier = Modifier,
) {
    Column(modifier, Arrangement.Center, Alignment.CenterHorizontally) {
        NavHost(controller, startDestination = navItems[0].type) {
            composable(navItems[0].type) {  }
            composable(navItems[1].type) {  }
            composable(navItems[2].type) {  }
            composable(navItems[3].type) {  }
            composable(navItems[4].type) {  }
            composable(navItems[5].type) {  }
            composable(navItems[6].type) {  }
            composable(navItems[7].type) {  }
            composable(navItems[8].type) {  }
            composable(navItems[9].type) {  }
            composable(navItems[10].type) {  }
            composable(navItems[11].type) {  }
        }
    }
}