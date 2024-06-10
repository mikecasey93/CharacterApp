package com.example.characterapp.data.remote.network.simpsons


import com.google.gson.annotations.SerializedName

data class MaintainerModel(
    @SerializedName("github")
    val github: String? = ""
)