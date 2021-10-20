package com.marvel.modele.characters

import com.google.gson.annotations.SerializedName
import com.marvel.modele.common.Thumbnail

data class Hero(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("comics") val comics: ExtraDataCharacter,
    @SerializedName("series") val series: ExtraDataCharacter,
    @SerializedName("stories") val stories: ExtraDataCharacter,
    @SerializedName("events") val events: ExtraDataCharacter
)
