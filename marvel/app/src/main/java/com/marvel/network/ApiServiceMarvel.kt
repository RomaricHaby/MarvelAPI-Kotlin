package com.marvel.network

import com.marvel.modele.characters.ResponseCharacterAPI
import com.marvel.modele.comics.ResponseComicsAPI
import com.marvel.modele.creators.ResponseCreatorsAPI
import com.marvel.modele.events.ResponseEventsAPI
import com.marvel.modele.series.ResponseSeriesAPI
import com.marvel.modele.stories.ResponseStoriesAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceMarvel {

    @GET("/v1/public/characters")
    suspend fun getAllCharacter(): Response<ResponseCharacterAPI>

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacter(
        @Path("id") id: String,
    ): Response<ResponseCharacterAPI>

    @GET("/v1/public/characters")
    suspend fun getCharacterWhitName(
        @Query("nameStartsWith") nameStartsWith: String,
    ): Response<ResponseCharacterAPI>

    @GET("/v1/public/characters/{id}/comics")
    suspend fun getCharacterComics(
        @Path("id") id: String,
    ): Response<ResponseComicsAPI>

    @GET("/v1/public/characters/{id}/series")
    suspend fun getCharacterSeries(
        @Path("id") id: String,
    ): Response<ResponseSeriesAPI>

    @GET("/v1/public/characters/{id}/stories")
    suspend fun getCharacterStories(
        @Path("id") id: String,
    ): Response<ResponseStoriesAPI>


    //Comics
    @GET("/v1/public/comics/{id}")
    suspend fun getComics(
        @Path("id") id: String,
    ): Response<ResponseComicsAPI>

    @GET("/v1/public/comics")
    suspend fun getAllComics(): Response<ResponseComicsAPI>

    @GET("/v1/public/comics/{id}/creators")
    suspend fun getComicsCreator(
        @Path("id") id: String,
    ): Response<ResponseCreatorsAPI>

    //Series
    @GET("/v1/public/series")
    suspend fun getAllSeries(): Response<ResponseSeriesAPI>

    //Creators
    @GET("/v1/public/creators")
    suspend fun getAllCreators(): Response<ResponseCreatorsAPI>

    //Events
    @GET("/v1/public/events")
    suspend fun getAllEvents(): Response<ResponseEventsAPI>

    //Stories
    @GET("/v1/public/stories")
    suspend fun getAllStories(): Response<ResponseStoriesAPI>



}