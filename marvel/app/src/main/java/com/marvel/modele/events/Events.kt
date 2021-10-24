package com.marvel.modele.events

import com.google.gson.annotations.SerializedName
import com.marvel.modele.common.type.TypeURL
import com.marvel.modele.common.*
import com.marvel.modele.common.uri.ResourcesURI

data class Events(
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("description") val description : String,
    @SerializedName("resourceURI") val resourceURI : String,
    @SerializedName("urls") val urls : List<TypeURL>,
    @SerializedName("modified") val modified : String,
    @SerializedName("start") val start : String,
    @SerializedName("end") val end : String,
    @SerializedName("thumbnail") val thumbnail : Thumbnail,
    @SerializedName("creators") val creators : SimpleCreators,
    @SerializedName("characters") val characters : SimpleCharacter,
    @SerializedName("stories") val stories : SimpleStories,
    @SerializedName("comics") val comics : SimpleComics,
    @SerializedName("series") val series : SimpleSeries,
    @SerializedName("next") val next : ResourcesURI,
    @SerializedName("previous") val previous : ResourcesURI
)
