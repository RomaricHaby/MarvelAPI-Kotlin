package com.marvel.usecase.character

import com.marvel.model.characters.ResponseCharacterAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetAllCharacterUseCase() : UseCase<ResponseCharacterAPI?> {

    override suspend fun execute(): Result<ResponseCharacterAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getAllCharacter()

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}