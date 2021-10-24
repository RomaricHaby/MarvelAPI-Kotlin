package com.marvel.usecase.character

import com.marvel.modele.characters.ResponseCharacterAPI
import com.marvel.modele.comics.ResponseComicsAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetCharacterByName (private val name: String) : UseCase<ResponseCharacterAPI?> {

    override suspend fun execute(): Result<ResponseCharacterAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getCharacterWhitName(name)

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}