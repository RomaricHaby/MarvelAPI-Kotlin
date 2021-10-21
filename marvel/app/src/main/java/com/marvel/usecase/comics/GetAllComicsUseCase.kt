package com.marvel.usecase.comics

import com.marvel.modele.comics.ResponseComicsAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetAllComicsUseCase () : UseCase<ResponseComicsAPI?> {
    override suspend fun execute(): Result<ResponseComicsAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getAllComics()

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}