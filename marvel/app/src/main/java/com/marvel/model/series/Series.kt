package com.marvel.model.series

import com.google.gson.annotations.SerializedName
import com.marvel.model.common.*
import com.marvel.model.common.type.TypeURL
import com.marvel.model.common.uri.ResourcesURI
import java.io.Serializable

data class Series(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String?,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("urls") val urls: List<TypeURL>,
    @SerializedName("startYear") val startYear: Int,
    @SerializedName("endYear") val endYear: Int,
    @SerializedName("rating") val rating: String,
    @SerializedName("type") val type: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("creators") val simpleCreator: SimpleCreator,
    @SerializedName("characters") val characters: SimpleCharacter,
    @SerializedName("stories") val simpleStorie: SimpleStorie,
    @SerializedName("comics") val comic: SimpleComic,
    @SerializedName("events") val simpleEvent: SimpleEvent,
    @SerializedName("next") val next: ResourcesURI,
    @SerializedName("previous") val previous: ResourcesURI
) : Serializable
