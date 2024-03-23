package com.alexander_nevsky_temple.domain.utils

sealed class ConnectionStatus<M>(val list: List<M>, val message: String = "") {
    class Loading<M>(list: List<M>) : ConnectionStatus<M>(list)
    class Success<M>(list: List<M>) : ConnectionStatus<M>(list)
    class ConnectionError<M>(message: String, list : List<M>) : ConnectionStatus<M>(list, message)
    class NoInternet<M>(message: String, list: List<M>) : ConnectionStatus<M>(list, message)
    class NoData<M>(message: String, list: List<M>) : ConnectionStatus<M>(list, message)
    class SerializationError<M>(message: String, list: List<M>) : ConnectionStatus<M>(list, message)
    class Unknown<M>(message: String, list: List<M>) : ConnectionStatus<M>(list, message)
}