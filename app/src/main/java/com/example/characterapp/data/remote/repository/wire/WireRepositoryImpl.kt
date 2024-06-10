package com.example.characterapp.data.remote.repository.wire

import com.example.characterapp.data.remote.network.wire.WireModel
import com.example.characterapp.data.remote.network.wire.WireRelatedTopicModel
import com.example.characterapp.data.remote.repository.simpsons.RemoteSimpsonDataSource
import com.example.characterapp.domain.entity.SimpsonObj
import com.example.characterapp.domain.entity.WireObj
import com.example.characterapp.domain.repo.SimpsonRepository
import com.example.characterapp.domain.repo.WireRepository
import kotlinx.coroutines.flow.Flow

class WireRepositoryImpl (
    private val remoteSource: RemoteWireDataSource
) : WireRepository {

    override fun getWires(): Flow<WireModel?> {
        return remoteSource.getWires()
    }

    override fun getWire(wireId: String?): Flow<WireObj> {
        return remoteSource.getWire(wireId)
    }
}