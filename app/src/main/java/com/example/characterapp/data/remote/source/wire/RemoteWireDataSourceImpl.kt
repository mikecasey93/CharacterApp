package com.example.characterapp.data.remote.source.wire

import com.example.characterapp.data.remote.endpoints.CharacterEndPoints
import com.example.characterapp.data.remote.network.simpsons.SimpsonModel
import com.example.characterapp.data.remote.network.simpsons.SimpsonRelatedTopicModel
import com.example.characterapp.data.remote.network.wire.WireModel
import com.example.characterapp.data.remote.network.wire.WireRelatedTopicModel
import com.example.characterapp.data.remote.repository.wire.RemoteWireDataSource
import com.example.characterapp.domain.entity.UseCaseException
import com.example.characterapp.domain.entity.WireObj
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteWireDataSourceImpl @Inject constructor(
    private val service: CharacterEndPoints
) : RemoteWireDataSource {

//    override suspend fun getWires(): WireModel {
//        return service.getWires()
//    }

    override fun getWires(): Flow<WireModel>  = flow {
        val wires = service.getWires()
        emit(wires)
    }.catch {
        throw UseCaseException.AppException(it)
    }

    override fun getWire(wireId: String?): Flow<WireObj> = flow {
        emit(service.getWire(wireId))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.AppException(it)
    }

    private fun convert(model: WireRelatedTopicModel) =
        WireObj(
            model?.firstURL,
            model?.icon?.uRL,
            model?.text,
        )
}