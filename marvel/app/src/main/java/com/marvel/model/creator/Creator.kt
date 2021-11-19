package com.marvel.model.creator

import com.google.gson.annotations.SerializedName
import com.marvel.model.common.SimpleComic
import com.marvel.model.common.SimpleEvent
import com.marvel.model.common.SimpleSerie
import com.marvel.model.common.Thumbnail
import com.marvel.model.common.type.TypeURL
import java.io.Serializable

data class Creator(
    @SerializedName("id") val id: Int,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("middleName") val middleName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("suffix") val suffix: String,
    @SerializedName("fullName") val fullName: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("comics") val comic: SimpleComic,
    @SerializedName("series") val serie: SimpleSerie,
    @SerializedName("stories") val stories: SimpleComic,
    @SerializedName("events") val event: SimpleEvent,
    @SerializedName("urls") val urls: List<TypeURL>
) : Serializable
