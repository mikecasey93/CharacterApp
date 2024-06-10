package com.example.characterapp.domain.usecase.wire

import com.example.characterapp.data.remote.network.wire.WireModel
import com.example.characterapp.data.remote.network.wire.WireRelatedTopicModel
import com.example.characterapp.domain.entity.WireObj
import com.example.characterapp.domain.repo.WireRepository
import com.example.characterapp.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class GetWireUseCase(
    configuration: Configuration,
    private val repo: WireRepository
) : UseCase<GetWireUseCase.Request, GetWireUseCase.Response>(configuration){

    override fun process(request: Request): Flow<Response> =
        repo.getWires().map {
            Response(it)
        }

    data object Request : UseCase.Request

    data class Response(val wires: WireModel?) : UseCase.Response
}