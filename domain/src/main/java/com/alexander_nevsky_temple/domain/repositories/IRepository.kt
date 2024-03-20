package com.alexander_nevsky_temple.domain.repositories

import com.alexander_nevsky_temple.domain.utils.ConnectionStatus

interface IRepository {
    suspend fun getList(): ConnectionStatus
}