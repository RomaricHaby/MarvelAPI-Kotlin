package com.marvel.modele.comics

import com.google.gson.annotations.SerializedName
import com.marvel.modele.common.uri.CollectionURIComics
import com.marvel.modele.common.uri.ResourcesURI
import com.marvel.modele.common.Thumbnail
import com.marvel.modele.common.type.TypeDateAPI
import com.marvel.modele.common.type.TypeLanguage
import com.marvel.modele.common.type.TypePrice
import com.marvel.modele.common.type.TypeURL
import java.io.Serializable


data class Comics(
    @SerializedName("id") val id: Int,
    @SerializedName("digitalId") val digitalId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("issueNumber") val issueNumber: Double,
    @SerializedName("variantDescription") val variantDescription: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("isbn") val isbn: String,
    @SerializedName("upc") val upc: String,
    @SerializedName("diamondCode") val diamondCode: String,
    @SerializedName("ean") val ean: String,
    @SerializedName("issn") val issn: String,
    @SerializedName("format") val format: String,
    @SerializedName("pageCount") val pageCount: Int,
    @SerializedName("textObjects") val textObjects: List<TypeLanguage>,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("urls") val urls: List<TypeURL>,
    @SerializedName("series") val series: ResourcesURI,
    @SerializedName("variants") val variants: List<ResourcesURI>,
    @SerializedName("collections") val collections: List<ResourcesURI>,
    @SerializedName("collectedIssues") val collectedIssues: List<ResourcesURI>,
    @SerializedName("dates") val dates: List<TypeDateAPI>,
    @SerializedName("prices") val prices: List<TypePrice>,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("images") val images: List<Thumbnail>,
    @SerializedName("creators") val creators: CollectionURIComics,
    @SerializedName("characters") val characters: CollectionURIComics,
    @SerializedName("stories") val stories: CollectionURIComics,
    @SerializedName("events") val events: CollectionURIComics
) : Serializable
