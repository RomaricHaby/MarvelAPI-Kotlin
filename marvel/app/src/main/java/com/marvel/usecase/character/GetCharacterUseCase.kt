package com.marvel.usecase.character

import com.marvel.modele.characters.ResponseCharacterAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetCharacterUseCase(private val id: String) : UseCase<ResponseCharacterAPI?> {

    override suspend fun execute(): Result<ResponseCharacterAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getCharacter(id)

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}