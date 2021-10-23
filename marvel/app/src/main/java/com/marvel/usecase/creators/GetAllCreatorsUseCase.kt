package com.marvel.usecase.creators

import com.marvel.modele.creators.ResponseCreatorsAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetAllCreatorsUseCase : UseCase<ResponseCreatorsAPI?> {
    override suspend fun execute(): Result<ResponseCreatorsAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getAllCreators()

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}