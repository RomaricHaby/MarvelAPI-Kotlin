package fr.iem.usecase.marvel.apimarvel

import fr.iem.modele.character.ResponseCharacterAPI
import fr.iem.modele.comics.ResponseComicsAPI
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