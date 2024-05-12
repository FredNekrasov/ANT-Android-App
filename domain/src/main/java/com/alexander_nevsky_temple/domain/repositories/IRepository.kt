package com.alexander_nevsky_temple.domain.repositories

import com.alexander_nevsky_temple.domain.utils.ActionStatus
import kotlinx.coroutines.flow.Flow

interface IRepository<M> {
    fun getList() : Flow<ActionStatus<M>>
}