package com.marvel.network

import com.marvel.modele.characters.ResponseCharacterAPI
import com.marvel.modele.comics.ResponseComicsAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceMarvel {

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacter(
        @Path("id") id: String,
    ): Response<ResponseCharacterAPI>

    @GET("/v1/public/comics/{id}")
    suspend fun getComics(
        @Path("id") id: String,
    ): Response<ResponseComicsAPI>

}