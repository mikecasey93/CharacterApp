package com.example.characterapp.data.remote.source.simpson

import com.example.characterapp.data.remote.endpoints.CharacterEndPoints
import com.example.characterapp.data.remote.network.simpsons.SimpsonModel
import com.example.characterapp.data.remote.network.simpsons.SimpsonRelatedTopicModel
import com.example.characterapp.data.remote.repository.simpsons.RemoteSimpsonDataSource
import com.example.characterapp.domain.entity.SimpsonObj
import com.example.characterapp.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteSimpsonDataSourceImpl @Inject constructor(
    private val service: CharacterEndPoints
) : RemoteSimpsonDataSource {


    override fun getSimpsons(): Flow<SimpsonModel> = flow {
        val simpsons = service.getSimpsons()
        emit(simpsons)
    }.catch {
        throw UseCaseException.AppException(it)
    }

    override fun getSimpson(simpsonId: String?): Flow<SimpsonObj> = flow {
        emit(service.getSimpson(simpsonId))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.AppException(it)
    }

    private fun convert(model: SimpsonRelatedTopicModel?) =
        SimpsonObj(
            model?.firstURL,
            model?.icon?.uRL,
            model?.text,
        )
}