package com.example.characterapp.domain.repo

import com.example.characterapp.data.remote.network.simpsons.SimpsonModel
import com.example.characterapp.data.remote.network.simpsons.SimpsonRelatedTopicModel
import com.example.characterapp.domain.entity.SimpsonObj
import kotlinx.coroutines.flow.Flow

interface SimpsonRepository {

    fun getSimpsons(): Flow<SimpsonModel?>

    fun getSimpson(simpsonId: String?): Flow<SimpsonObj>
}