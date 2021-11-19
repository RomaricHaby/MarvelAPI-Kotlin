package com.marvel.usecase.character

import com.marvel.model.characters.ResponseCharactersAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetAllCharactersUseCase : UseCase<ResponseCharactersAPI?> {

    override suspend fun execute(): Result<ResponseCharactersAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getAllCharacters()

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}