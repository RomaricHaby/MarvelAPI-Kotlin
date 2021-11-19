package com.marvel.network

import com.marvel.model.character.ResponseCharactersAPI
import com.marvel.model.comic.ResponseComicsAPI
import com.marvel.model.creator.ResponseCreatorsAPI
import com.marvel.model.event.ResponseEventsAPI
import com.marvel.model.serie.ResponseSeriesAPI
import com.marvel.model.storie.ResponseStoriesAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceMarvel {

    //Characters
    @GET("/v1/public/characters")
    suspend fun getAllCharacters(): Response<ResponseCharactersAPI>

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacterByID(
        @Path("id") id: String,
    ): Response<ResponseCharactersAPI>

    @GET("/v1/public/characters")
    suspend fun getCharacterByName(
        @Query("nameStartsWith") nameStartsWith: String,
    ): Response<ResponseCharactersAPI>

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
    @GET("/v1/public/comics")
    suspend fun getAllComics(): Response<ResponseComicsAPI>

    @GET("/v1/public/comics")
    suspend fun getComicByName(
        @Query("titleStartsWith") titleStartsWith: String,
    ): Response<ResponseComicsAPI>

    @GET("/v1/public/comics/{id}/creators")
    suspend fun getComicCreators(
        @Path("id") id: String,
    ): Response<ResponseCreatorsAPI>


    //Series
    @GET("/v1/public/series")
    suspend fun getAllSeries(): Response<ResponseSeriesAPI>


    //Events
    @GET("/v1/public/events")
    suspend fun getAllEvents(): Response<ResponseEventsAPI>

    @GET("/v1/public/events")
    suspend fun getEventByName(
        @Query("nameStartsWith") nameStartsWith: String,
    ): Response<ResponseEventsAPI>
}