package com.alexander_nevsky_temple.domain.repositories

import com.alexander_nevsky_temple.domain.utils.ActionStatus
import kotlinx.coroutines.flow.StateFlow

interface IRepository<M> {
    suspend fun getList() : StateFlow<ActionStatus<M>>
}