package com.marvel.modele.characters

import com.google.gson.annotations.SerializedName
import com.marvel.modele.characters.DataCharacter

data class ResponseCharacterAPI(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("attributionText") val attributionText: String,
    @SerializedName("attributionHTML") val attributionHTML: String,
    @SerializedName("etag") val etag: String,
    @SerializedName("data") val dataCharacter: DataCharacter
)
