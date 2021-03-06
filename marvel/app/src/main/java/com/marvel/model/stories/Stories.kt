package com.marvel.model.stories

import com.google.gson.annotations.SerializedName
import com.marvel.model.common.*
import com.marvel.model.common.uri.ResourcesURI

data class Stories(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("type") val type: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("creators") val creator: SimpleCreator,
    @SerializedName("characters") val characters: SimpleCharacter,
    @SerializedName("series") val series: SimpleSeries,
    @SerializedName("comics") val comic: SimpleComic,
    @SerializedName("events") val event: SimpleEvent,
    @SerializedName("originalIssue") val originalIssue: ResourcesURI
)
