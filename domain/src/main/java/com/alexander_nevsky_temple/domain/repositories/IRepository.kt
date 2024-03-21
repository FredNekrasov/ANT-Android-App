package com.alexander_nevsky_temple.domain.repositories

import com.alexander_nevsky_temple.domain.utils.ConnectionStatus
import kotlinx.coroutines.flow.StateFlow

interface IRepository {
    suspend fun getList(): StateFlow<ConnectionStatus>
}