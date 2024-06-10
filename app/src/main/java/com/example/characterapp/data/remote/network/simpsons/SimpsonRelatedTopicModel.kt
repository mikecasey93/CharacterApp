package com.example.characterapp.data.remote.network.simpsons


import com.google.gson.annotations.SerializedName

data class SimpsonRelatedTopicModel(
    @SerializedName("FirstURL")
    val firstURL: String? = "",
    @SerializedName("Icon")
    val icon: IconModel? = IconModel(),
    @SerializedName("Result")
    val result: String? = "",
    @SerializedName("Text")
    val text: String? = ""
)