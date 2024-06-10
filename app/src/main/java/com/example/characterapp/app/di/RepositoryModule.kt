package com.example.characterapp.app.di

import com.example.characterapp.data.remote.repository.simpsons.RemoteSimpsonDataSource
import com.example.characterapp.data.remote.repository.simpsons.SimpsonRepositoryImpl
import com.example.characterapp.data.remote.repository.wire.RemoteWireDataSource
import com.example.characterapp.data.remote.repository.wire.WireRepositoryImpl
import com.example.characterapp.domain.repo.SimpsonRepository
import com.example.characterapp.domain.repo.WireRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideSimpsonRepository(
        remoteSource: RemoteSimpsonDataSource,
    ): SimpsonRepository = SimpsonRepositoryImpl(
        remoteSource
    )

    @Provides
    fun provideWireRepository(
        remoteSource: RemoteWireDataSource,
    ): WireRepository = WireRepositoryImpl(
        remoteSource
    )
}