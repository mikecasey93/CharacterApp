package com.example.characterapp.domain.usecase.simpson

import com.example.characterapp.data.remote.network.simpsons.SimpsonModel
import com.example.characterapp.domain.entity.SimpsonObj
import com.example.characterapp.domain.repo.SimpsonRepository
import com.example.characterapp.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetSimpsonUseCase(
    configuration: Configuration,
    private val repo: SimpsonRepository
) : UseCase<GetSimpsonUseCase.Request, GetSimpsonUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getSimpsons().map {
            Response(it)
        }

    data object Request : UseCase.Request

    data class Response(val simpsons: SimpsonModel?) : UseCase.Response
}