package com.marvel.model.common

import com.google.gson.annotations.SerializedName
import com.marvel.model.common.uri.ResourcesURI

data class SimpleCharacter(
    @SerializedName("available") val available: Int,
    @SerializedName("collectionURI") val collectionURI: String,
    @SerializedName("items") val items: List<ResourcesURI>,
    @SerializedName("returned") val returned: Int
)
