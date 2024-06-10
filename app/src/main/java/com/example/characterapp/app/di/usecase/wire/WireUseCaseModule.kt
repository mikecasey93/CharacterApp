package com.example.characterapp.app.di.usecase.wire

import com.example.characterapp.domain.repo.SimpsonRepository
import com.example.characterapp.domain.repo.WireRepository
import com.example.characterapp.domain.usecase.UseCase
import com.example.characterapp.domain.usecase.simpson.GetSimpsonByIdUseCase
import com.example.characterapp.domain.usecase.simpson.GetSimpsonUseCase
import com.example.characterapp.domain.usecase.wire.GetWireByIdUseCase
import com.example.characterapp.domain.usecase.wire.GetWireUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class WireUseCaseModule {

    @Provides
    fun provideGetWireUseCase(
        configuration: UseCase.Configuration,
        repository: WireRepository
    ): GetWireUseCase = GetWireUseCase(
        configuration,
        repository
    )

    @Provides
    fun GetWireByIdUseCase(
        configuration: UseCase.Configuration,
        repository: WireRepository
    ): GetWireByIdUseCase = GetWireByIdUseCase(
        configuration,
        repository
    )
}