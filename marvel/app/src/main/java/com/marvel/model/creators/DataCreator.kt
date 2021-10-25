package com.marvel.model.creators

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataCreator(
    @SerializedName("offset") val offset : Int,
    @SerializedName("limit") val limit : Int,
    @SerializedName("total") val total : Int,
    @SerializedName("count") val count : Int,
    @SerializedName("results") val results : List<Creator>
) : Serializable
