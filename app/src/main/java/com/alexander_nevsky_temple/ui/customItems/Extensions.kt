package com.alexander_nevsky_temple.ui.customItems

import android.content.Context
import android.widget.Toast
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus.*

// Extensions functions for convenience and simplification
fun Context.displayMessage(
    message : String, duration : Int = Toast.LENGTH_SHORT
) = Toast.makeText(this, message, duration).show()
fun ConnectionStatus.getMessage() = when(this) {
    CONNECTION_ERROR -> Info.CONNECTION_ERROR
    NO_INTERNET -> Info.NO_INTERNET
    NO_DATA -> Info.NO_DATA
    SERIALIZATION_ERROR -> Info.SERIALIZATION_ERROR
    UNKNOWN -> Info.UNKNOWN
    else -> ""
}
fun ConnectionStatus.isError() = (this != SUCCESS) && (this != LOADING)
fun List<String>.getNotNull(index: Int): String = this.getOrNull(index).toString()
// Aliases for convenience and simplification
typealias SAction = (String) -> Unit
typealias Action = () -> Unit