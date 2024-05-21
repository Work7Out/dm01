package com.edurda77.dm01.di

import com.edurda77.dm01.data.repository.RemoteRepositoryImpl
import com.edurda77.dm01.domain.repository.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(
        repository: RemoteRepositoryImpl
    ): RemoteRepository

}