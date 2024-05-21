package com.alexander_nevsky_temple

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.alexander_nevsky_temple.presentation.MainEntryPoint
import com.alexander_nevsky_temple.ui.customItems.openWebPage
import com.alexander_nevsky_temple.ui.theme.AlexanderNevskyTempleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val openWebPage = { url: String -> openWebPage(url) }
        setContent {
            AlexanderNevskyTempleTheme {
                Surface(Modifier.fillMaxSize(),color = MaterialTheme.colorScheme.background) {
                    MainEntryPoint(openWebPage, { action, data -> startActivity(Intent(action, Uri.parse(data))) })
                }
            }
        }
    }
}