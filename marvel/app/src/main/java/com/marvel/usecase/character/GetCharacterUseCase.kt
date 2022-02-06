package com.marvel.usecase.character

import com.marvel.model.character.ResponseCharactersAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetCharacterUseCase(private val id: String) : UseCase<ResponseCharactersAPI?> {

    override suspend fun execute(): Result<ResponseCharactersAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getCharacterByID(id)

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}