package com.marvel.modele.characters

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ExtraDataCharacter(
    @SerializedName("available") val available: Int,
    @SerializedName("collectionURI") val collectionURI: String,
    @SerializedName("returned") val returned: Int?
) : Serializable
