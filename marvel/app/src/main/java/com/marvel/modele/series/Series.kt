package com.marvel.modele.series

import com.google.gson.annotations.SerializedName
import com.marvel.modele.common.type.TypeURL
import com.marvel.modele.common.uri.ResourcesURI
import com.marvel.modele.common.*

data class Series(
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("description") val description : String,
    @SerializedName("resourceURI") val resourceURI : String,
    @SerializedName("urls") val urls : List<TypeURL>,
    @SerializedName("startYear") val startYear : Int,
    @SerializedName("endYear") val endYear : Int,
    @SerializedName("rating") val rating : String,
    @SerializedName("type") val type : String,
    @SerializedName("modified") val modified : String,
    @SerializedName("thumbnail") val thumbnail : Thumbnail,
    @SerializedName("creators") val simpleCreators : SimpleCreators,
    @SerializedName("characters") val characters : SimpleCharacter,
    @SerializedName("stories") val simpleStories : SimpleStories,
    @SerializedName("comics") val comics : SimpleComics,
    @SerializedName("events") val simpleEvents : SimpleEvents,
    @SerializedName("next") val next : ResourcesURI,
    @SerializedName("previous") val previous : ResourcesURI
)
