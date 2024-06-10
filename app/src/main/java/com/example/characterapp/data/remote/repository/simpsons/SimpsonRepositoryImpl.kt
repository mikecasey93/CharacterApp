package com.example.characterapp.data.remote.repository.simpsons

import com.example.characterapp.data.remote.network.simpsons.SimpsonModel
import com.example.characterapp.data.remote.network.simpsons.SimpsonRelatedTopicModel
import com.example.characterapp.domain.entity.SimpsonObj
import com.example.characterapp.domain.repo.SimpsonRepository
import kotlinx.coroutines.flow.Flow

class SimpsonRepositoryImpl(
    private val remoteSource: RemoteSimpsonDataSource
) : SimpsonRepository{

    override fun getSimpsons(): Flow<SimpsonModel?> {
        return remoteSource.getSimpsons()
    }

    override fun getSimpson(simpsonId: String?): Flow<SimpsonObj> {
        return remoteSource.getSimpson(simpsonId)
    }
}