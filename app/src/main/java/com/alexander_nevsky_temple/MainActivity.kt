package com.alexander_nevsky_temple

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.alexander_nevsky_temple.presentation.MainEntryPoint
import com.alexander_nevsky_temple.ui.customItems.Strings
import com.alexander_nevsky_temple.ui.theme.AlexanderNevskyTempleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val screenRoutes = listOf(
            Strings.MAIN,
            Strings.PARISH_LIFE,
            Strings.SCHEDULE,
            Strings.SPIRITUAL_TALKS,
            Strings.YOUTH_CLUB,
            Strings.PRIESTHOOD,
            Strings.ADVICES,
            Strings.HISTORY,
            Strings.SACRAMENTS,
            Strings.CONTACTS,
            Strings.INFORMATION,
            Strings.VOLUNTEERISM
        )
        setContent {
            AlexanderNevskyTempleTheme {
                Surface(Modifier.fillMaxSize(),color = MaterialTheme.colorScheme.background) {
                    MainEntryPoint(screenRoutes)
                }
            }
        }
    }
}