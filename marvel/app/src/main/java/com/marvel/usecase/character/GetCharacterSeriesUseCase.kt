package com.marvel.usecase.character

import com.marvel.modele.comics.ResponseComicsAPI
import com.marvel.modele.series.ResponseSeriesAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetCharacterSeriesUseCase (private val id: String) : UseCase<ResponseSeriesAPI?> {

    override suspend fun execute(): Result<ResponseSeriesAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getCharacterSeries(id)

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}