package com.example.characterapp.app.di.usecase.simpsons

import com.example.characterapp.domain.repo.SimpsonRepository
import com.example.characterapp.domain.usecase.UseCase
import com.example.characterapp.domain.usecase.simpson.GetSimpsonByIdUseCase
import com.example.characterapp.domain.usecase.simpson.GetSimpsonUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SimpsonUseCaseModule {

    @Provides
    fun provideGetSimpsonUseCase(
        configuration: UseCase.Configuration,
        repository: SimpsonRepository
    ): GetSimpsonUseCase = GetSimpsonUseCase(
        configuration,
        repository
    )

    @Provides
    fun GetSimpsonByIdUseCase(
        configuration: UseCase.Configuration,
        repository: SimpsonRepository
    ): GetSimpsonByIdUseCase = GetSimpsonByIdUseCase(
        configuration,
        repository
    )
}