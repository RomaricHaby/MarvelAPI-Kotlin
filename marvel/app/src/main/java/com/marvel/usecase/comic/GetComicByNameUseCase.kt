package com.marvel.usecase.comic

import com.marvel.model.comics.ResponseComicsAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetComicByNameUseCase(private val name: String) : UseCase<ResponseComicsAPI?> {

    override suspend fun execute(): Result<ResponseComicsAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getComicByName(name)

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}