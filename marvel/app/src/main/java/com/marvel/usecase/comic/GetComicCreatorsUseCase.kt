package com.marvel.usecase.comic

import com.marvel.model.creator.ResponseCreatorsAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetComicCreatorsUseCase(private val id: String) : UseCase<ResponseCreatorsAPI?> {

    override suspend fun execute(): Result<ResponseCreatorsAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getComicCreators(id)

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}