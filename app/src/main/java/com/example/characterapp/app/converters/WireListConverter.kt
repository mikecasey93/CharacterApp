package com.example.characterapp.app.converters

import android.content.Context
import com.example.characterapp.app.model.Wire
import com.example.characterapp.app.model.WireListModel
import com.example.characterapp.common.state.CommonResultConverter
import com.example.characterapp.domain.usecase.wire.GetWireUseCase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class WireListConverter  @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetWireUseCase.Response, WireListModel>() {

    override fun convertSuccess(
        data: GetWireUseCase.Response
    ) : WireListModel {
        return WireListModel(
            wires = data.wires?.relatedTopics?.map {
                Wire(
                    firstUrl = it?.firstURL,
                    icon = it?.icon?.uRL,
                    text = it?.text
                )
            } ?: listOf()
        )
    }
}