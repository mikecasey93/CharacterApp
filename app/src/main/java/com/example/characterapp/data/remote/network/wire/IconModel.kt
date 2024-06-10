package com.example.characterapp.data.remote.network.wire


import com.google.gson.annotations.SerializedName

data class IconModel(
    @SerializedName("Height")
    val height: String? = "",
    @SerializedName("URL")
    val uRL: String? = "",
    @SerializedName("Width")
    val width: String? = ""
)