package com.alexander_nevsky_temple.domain.utils

sealed class ActionStatus<M>(val list: List<M>, val status: ConnectionStatus) {
    class Loading<M>(list: List<M>) : ActionStatus<M>(list, ConnectionStatus.LOADING)
    class Success<M>(list: List<M>) : ActionStatus<M>(list, ConnectionStatus.SUCCESS)
    class Error<M>(list: List<M>, status : ConnectionStatus) : ActionStatus<M>(list, status)
}