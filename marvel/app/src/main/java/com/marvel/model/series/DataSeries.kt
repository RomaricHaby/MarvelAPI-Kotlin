package com.marvel.model.series

import com.google.gson.annotations.SerializedName

data class DataSeries(
    @SerializedName("offset") val offset : Int,
    @SerializedName("limit") val limit : Int,
    @SerializedName("total") val total : Int,
    @SerializedName("count") val count : Int,
    @SerializedName("results") val results : List<Series>
)