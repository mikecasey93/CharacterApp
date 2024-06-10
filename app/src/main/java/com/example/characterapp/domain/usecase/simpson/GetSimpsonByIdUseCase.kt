package com.example.characterapp.domain.usecase.simpson

import com.example.characterapp.domain.entity.SimpsonObj
import com.example.characterapp.domain.repo.SimpsonRepository
import com.example.characterapp.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetSimpsonByIdUseCase(
    configuration: UseCase.Configuration,
    private val repo: SimpsonRepository
) : UseCase<GetSimpsonByIdUseCase.Request, GetSimpsonByIdUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getSimpson(request.simpsonId).map {
            Response(it)
        }


    data class Request(val simpsonId: String?) : UseCase.Request

    data class Response(val simpson: SimpsonObj?) : UseCase.Response
}