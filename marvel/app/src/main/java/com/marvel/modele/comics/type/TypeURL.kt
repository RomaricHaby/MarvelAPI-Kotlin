package com.marvel.modele.comics.type

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TypeURL(
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String,
): Serializable
