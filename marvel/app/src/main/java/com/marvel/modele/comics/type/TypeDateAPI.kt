package com.marvel.modele.comics.type

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TypeDateAPI(
    @SerializedName("type") val type: String,
    @SerializedName("date") val date: String,
): Serializable
