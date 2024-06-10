package com.example.characterapp.data.remote.endpoints

import com.example.characterapp.data.remote.network.simpsons.SimpsonModel
import com.example.characterapp.data.remote.network.simpsons.SimpsonRelatedTopicModel
import com.example.characterapp.data.remote.network.wire.WireModel
import com.example.characterapp.data.remote.network.wire.WireRelatedTopicModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface CharacterEndPoints {

    @GET("?q=simpsons+characters&format=json")
    suspend fun getSimpsons(): SimpsonModel

    @GET("?q=simpsons+characters&format=json")
    suspend fun getSimpson(id: String?): SimpsonRelatedTopicModel

    @GET("?q=wire+characters&format=json")
    suspend fun getWires(): WireModel

    @GET("?q=wire+characters&format=json")
    suspend fun getWire(id: String?): WireRelatedTopicModel

}