package com.alexander_nevsky_temple.domain.utils

sealed class ConnectionStatus {
    data class Success<M>(val list: List<M> = emptyList()) : ConnectionStatus()
    data class NoInternet<M>(
        val message : String, val list : List<M> = emptyList()
    ) : ConnectionStatus()
    data class NoData<M>(
        val message : String, val list : List<M> = emptyList()
    ) : ConnectionStatus()
    data class JsonConversionError<M>(
        val message : String, val list : List<M> = emptyList()
    ) : ConnectionStatus()
    data class Unknown<M>(
        val message : String, val list : List<M> = emptyList()
    ) : ConnectionStatus()
}