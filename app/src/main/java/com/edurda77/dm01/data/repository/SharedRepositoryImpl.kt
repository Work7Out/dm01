package com.edurda77.dm01.data.repository

import android.app.Application
import android.content.Context
import com.edurda77.dm01.domain.repository.SharedRepository
import com.edurda77.dm01.domain.utils.SHARED_DATA
import com.edurda77.dm01.domain.utils.SHARED_IS_FIRST
import javax.inject.Inject

class SharedRepositoryImpl @Inject constructor(
    application: Application,
): SharedRepository {
    private val sharedPref =
        application.getSharedPreferences(SHARED_DATA, Context.MODE_PRIVATE)

    override suspend fun getSharedFirst(): Boolean {
        return sharedPref.getBoolean(SHARED_IS_FIRST, true)
    }

    override suspend fun setSharedFirst(date: Boolean) {
        sharedPref.edit().putBoolean(SHARED_IS_FIRST, date).apply()
    }
}