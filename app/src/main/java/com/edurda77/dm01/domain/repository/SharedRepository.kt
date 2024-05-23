package com.edurda77.dm01.domain.repository

interface SharedRepository {
    suspend fun getSharedFirst(): Boolean
    suspend fun setSharedFirst(date: Boolean)
}