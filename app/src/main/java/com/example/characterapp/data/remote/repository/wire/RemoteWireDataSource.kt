package com.example.characterapp.data.remote.repository.wire

import com.example.characterapp.data.remote.network.wire.WireModel
import com.example.characterapp.domain.entity.SimpsonObj
import com.example.characterapp.domain.entity.WireObj
import kotlinx.coroutines.flow.Flow

interface RemoteWireDataSource {

    fun getWires(): Flow<WireModel?>

    fun getWire(wireId: String?): Flow<WireObj>
}