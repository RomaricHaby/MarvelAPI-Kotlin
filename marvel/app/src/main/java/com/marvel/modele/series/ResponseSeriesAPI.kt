package com.marvel.modele.series

import com.google.gson.annotations.SerializedName

data class ResponseSeriesAPI (
    @SerializedName("code") val code : Int,
    @SerializedName("status") val status : String,
    @SerializedName("copyright") val copyright : String,
    @SerializedName("attributionText") val attributionText : String,
    @SerializedName("attributionHTML") val attributionHTML : String,
    @SerializedName("etag") val etag : String,
    @SerializedName("data") val data : DataSeries
)