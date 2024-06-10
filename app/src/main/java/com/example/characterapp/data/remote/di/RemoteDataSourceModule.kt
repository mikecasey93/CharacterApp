package com.example.characterapp.data.remote.di

import com.example.characterapp.data.remote.repository.simpsons.RemoteSimpsonDataSource
import com.example.characterapp.data.remote.repository.wire.RemoteWireDataSource
import com.example.characterapp.data.remote.source.simpson.RemoteSimpsonDataSourceImpl
import com.example.characterapp.data.remote.source.wire.RemoteWireDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindSimpsonInfoDataSource(dataSource: RemoteSimpsonDataSourceImpl): RemoteSimpsonDataSource

    @Binds
    abstract fun bindWireInfoDataSource(dataSource: RemoteWireDataSourceImpl): RemoteWireDataSource
}