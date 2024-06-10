package com.example.characterapp.app.converters

import android.content.Context
import com.example.characterapp.app.model.Simpson
import com.example.characterapp.app.model.SimpsonListModel
import com.example.characterapp.common.state.CommonResultConverter
import com.example.characterapp.domain.usecase.simpson.GetSimpsonUseCase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SimpsonListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetSimpsonUseCase.Response, SimpsonListModel>() {

    override fun convertSuccess(
        data: GetSimpsonUseCase.Response
    ) : SimpsonListModel {
        return SimpsonListModel(
            simpsons = data.simpsons?.relatedTopics?.map {
                Simpson(
                    firstUrl = it?.firstURL,
                    icon = it?.icon?.uRL,
                    text = it?.text
                )
            } ?: listOf()
        )
    }
}