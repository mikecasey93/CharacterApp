package com.example.characterapp.domain.repo

import com.example.characterapp.data.remote.network.simpsons.SimpsonRelatedTopicModel
import com.example.characterapp.data.remote.network.wire.WireModel
import com.example.characterapp.data.remote.network.wire.WireRelatedTopicModel
import com.example.characterapp.domain.entity.WireObj
import kotlinx.coroutines.flow.Flow

interface WireRepository {

    fun getWires(): Flow<WireModel?>

    fun getWire(wireId: String?): Flow<WireObj>
}