package com.alexander_nevsky_temple.domain.useCases

import com.alexander_nevsky_temple.domain.utils.ConnectionStatus
import kotlinx.coroutines.flow.StateFlow

interface IGetListUseCase<M> {
    suspend fun getList() : StateFlow<ConnectionStatus<M>>
}