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
import com.alexander_nevsky_temple.ui.customItems.Info
import com.alexander_nevsky_temple.ui.theme.AlexanderNevskyTempleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navItems = listOf(Info.MAIN, Info.PARISH_LIFE, Info.SCHEDULE, Info.SPIRITUAL_TALKS, Info.YOUTH_CLUB, Info.PRIESTHOOD, Info.ADVICES, Info.HISTORY, Info.SACRAMENTS, Info.CONTACTS, Info.INFORMATION, Info.VOLUNTEERISM)
        setContent {
            AlexanderNevskyTempleTheme {
                Surface(Modifier.fillMaxSize(),color = MaterialTheme.colorScheme.background) {
                    MainEntryPoint(navItems) { data -> startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(data))) }
                }
            }
        }
    }
}