package com.marvel.modele.stories

import com.google.gson.annotations.SerializedName
import com.marvel.modele.common.*
import com.marvel.modele.common.uri.ResourcesURI

data class Stories(
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("description") val description : String,
    @SerializedName("resourceURI") val resourceURI : String,
    @SerializedName("type") val type : String,
    @SerializedName("modified") val modified : String,
    @SerializedName("thumbnail") val thumbnail : String,
    @SerializedName("creators") val creators : SimpleCreators,
    @SerializedName("characters") val characters : SimpleCharacter,
    @SerializedName("series") val series : SimpleSeries,
    @SerializedName("comics") val comics : SimpleComics,
    @SerializedName("events") val events : SimpleEvents,
    @SerializedName("originalIssue") val originalIssue : ResourcesURI
)
