package com.marvel.modele.common

import com.google.gson.annotations.SerializedName
import com.marvel.modele.common.uri.ResourcesURI

data class SimpleCreators(
    @SerializedName("available") val available : Int,
    @SerializedName("collectionURI") val collectionURI : String,
    @SerializedName("items") val items : List<ResourcesURI>,
    @SerializedName("returned") val returned : Int
)
