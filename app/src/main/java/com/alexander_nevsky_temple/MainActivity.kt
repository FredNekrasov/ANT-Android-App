package com.alexander_nevsky_temple

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.alexander_nevsky_temple.di.utils.DIStrings
import com.alexander_nevsky_temple.presentation.MainEntryPoint
import com.alexander_nevsky_temple.presentation.viewModels.ArticleTypeVM
import com.alexander_nevsky_temple.ui.customItems.*
import com.alexander_nevsky_temple.ui.theme.AlexanderNevskyTempleTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.qualifier.named

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val articleTypeVM = getViewModel<ArticleTypeVM>(qualifier = named(DIStrings.VIEWMODEL + DIStrings.ARTICLE_TYPE))
        setContent {
            AlexanderNevskyTempleTheme {
                Surface(Modifier.fillMaxSize(),color = MaterialTheme.colorScheme.background) {
                    val state = articleTypeVM.articleTypesSF.collectAsState().value
                    if(state.status.isError()) displayMessage(state.status.getMessage(), Toast.LENGTH_LONG)
                    MainEntryPoint(state.list)
                }
            }
        }
    }
}