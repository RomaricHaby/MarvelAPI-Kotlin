package com.marvel.model.creator

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseCreatorsAPI(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("attributionText") val attributionText: String,
    @SerializedName("attributionHTML") val attributionHTML: String,
    @SerializedName("etag") val etag: String,
    @SerializedName("data") val dataCreators: DataCreators
) : Serializable
