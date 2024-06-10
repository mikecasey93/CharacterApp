package com.example.characterapp.data.remote.repository.simpsons

import com.example.characterapp.data.remote.network.simpsons.SimpsonModel
import com.example.characterapp.domain.entity.SimpsonObj
import kotlinx.coroutines.flow.Flow

interface RemoteSimpsonDataSource {

    fun getSimpsons(): Flow<SimpsonModel?>

    fun getSimpson(simpsonId: String?): Flow<SimpsonObj>
}