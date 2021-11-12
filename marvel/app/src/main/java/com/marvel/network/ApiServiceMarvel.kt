package com.marvel.network

import com.marvel.model.characters.ResponseCharacterAPI
import com.marvel.model.comics.ResponseComicsAPI
import com.marvel.model.creators.ResponseCreatorsAPI
import com.marvel.model.events.ResponseEventsAPI
import com.marvel.model.series.ResponseSeriesAPI
import com.marvel.model.stories.ResponseStoriesAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceMarvel {

    //Characters
    @GET("/v1/public/characters")
    suspend fun getAllCharacter(): Response<ResponseCharacterAPI>

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacter(
        @Path("id") id: String,
    ): Response<ResponseCharacterAPI>

    @GET("/v1/public/characters")
    suspend fun getCharacterByName(
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


    @GET("/v1/public/comics")
    suspend fun getComicsByName(
        @Query("titleStartsWith") titleStartsWith: String,
    ): Response<ResponseComicsAPI>

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

    @GET("/v1/public/events")
    suspend fun getEventByName(
        @Query("nameStartsWith") nameStartsWith: String,
    ): Response<ResponseEventsAPI>

    //Stories
    @GET("/v1/public/stories")
    suspend fun getAllStories(): Response<ResponseStoriesAPI>


}