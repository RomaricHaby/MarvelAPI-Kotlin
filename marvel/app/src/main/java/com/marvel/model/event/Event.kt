package com.marvel.model.event

import com.google.gson.annotations.SerializedName
import com.marvel.model.common.*
import com.marvel.model.common.type.TypeURL
import com.marvel.model.common.uri.ResourcesURI
import java.io.Serializable

data class Event(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("urls") val urls: List<TypeURL>,
    @SerializedName("modified") val modified: String,
    @SerializedName("start") val start: String,
    @SerializedName("end") val end: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("creators") val creator: SimpleCreator,
    @SerializedName("characters") val characters: SimpleCharacter,
    @SerializedName("stories") val storie: SimpleStorie,
    @SerializedName("comics") val comic: SimpleComic,
    @SerializedName("series") val serie: SimpleSerie,
    @SerializedName("next") val next: ResourcesURI,
    @SerializedName("previous") val previous: ResourcesURI
) : Serializable
