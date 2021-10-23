package com.marvel.modele.creators

import com.google.gson.annotations.SerializedName
import com.marvel.modele.comics.type.TypeURL
import com.marvel.modele.common.SimpleComics
import com.marvel.modele.common.SimpleEvents
import com.marvel.modele.common.SimpleSeries
import com.marvel.modele.common.Thumbnail
import java.io.Serializable

data class Creator(
    @SerializedName("id") val id : Int,
    @SerializedName("firstName") val firstName : String,
    @SerializedName("middleName") val middleName : String,
    @SerializedName("lastName") val lastName : String,
    @SerializedName("suffix") val suffix : String,
    @SerializedName("fullName") val fullName : String,
    @SerializedName("modified") val modified : String,
    @SerializedName("thumbnail") val thumbnail : Thumbnail,
    @SerializedName("resourceURI") val resourceURI : String,
    @SerializedName("comics") val comics : SimpleComics,
    @SerializedName("series") val series : SimpleSeries,
    @SerializedName("stories") val stories : SimpleComics,
    @SerializedName("events") val events : SimpleEvents,
    @SerializedName("urls") val urls : List<TypeURL>
) : Serializable
