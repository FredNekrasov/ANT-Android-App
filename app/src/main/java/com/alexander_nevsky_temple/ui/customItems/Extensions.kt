package com.alexander_nevsky_temple.ui.customItems

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.app.TaskStackBuilder
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus.*

fun Context.displayMessage(
    message : String, duration : Int = Toast.LENGTH_SHORT
) = Toast.makeText(this, message, duration).show()
fun ConnectionStatus.getMessage() = when(this) {
    CONNECTION_ERROR -> Strings.CONNECTION_ERROR
    NO_INTERNET -> Strings.NO_INTERNET
    NO_DATA -> Strings.NO_DATA
    SERIALIZATION_ERROR -> Strings.SERIALIZATION_ERROR
    UNKNOWN -> Strings.UNKNOWN
    else -> ""
}
fun ConnectionStatus.isError() = (this != SUCCESS) && (this != LOADING)
fun List<String>.getNotNull(index: Int): String = this.getOrNull(index).toString()
fun ComponentActivity.openWebPage(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    TaskStackBuilder.create(applicationContext).run {
        addNextIntentWithParentStack(intent)
        getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
    }?.send()
}
// custom types
typealias SAction = (String) -> Unit
typealias SSAction = (String, String) -> Unit
typealias Action = () -> Unit