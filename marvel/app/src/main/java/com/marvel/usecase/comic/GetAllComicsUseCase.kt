package com.marvel.usecase.comic

import com.marvel.model.comic.ResponseComicsAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetAllComicsUseCase : UseCase<ResponseComicsAPI?> {
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