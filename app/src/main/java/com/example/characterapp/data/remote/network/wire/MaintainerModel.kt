package com.example.characterapp.data.remote.network.wire


import com.google.gson.annotations.SerializedName

data class MaintainerModel(
    @SerializedName("github")
    val github: String? = ""
)