package com.marvel.usecase.comics

import com.marvel.modele.comics.ResponseComicsAPI
import com.marvel.modele.creators.ResponseCreatorsAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetComicsCreatorsUseCase(private val id: String) : UseCase<ResponseCreatorsAPI?> {

    override suspend fun execute(): Result<ResponseCreatorsAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getComicsCreator(id)

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}