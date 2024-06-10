package com.example.characterapp.domain.usecase.wire

import com.example.characterapp.domain.entity.WireObj
import com.example.characterapp.domain.repo.WireRepository
import com.example.characterapp.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetWireByIdUseCase(
    configuration: UseCase.Configuration,
    private val repo: WireRepository
) : UseCase<GetWireByIdUseCase.Request, GetWireByIdUseCase.Response>(configuration){

    override fun process(request: Request): Flow<Response> =
        repo.getWire(request.wireId).map {
            Response(it)
        }

    data class Request(val wireId: String?) : UseCase.Request

    data class Response(val wire: WireObj?) : UseCase.Response
}