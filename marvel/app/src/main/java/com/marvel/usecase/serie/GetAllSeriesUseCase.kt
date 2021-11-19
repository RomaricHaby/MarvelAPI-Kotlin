package com.marvel.usecase.serie

import com.marvel.model.series.ResponseSeriesAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetAllSeriesUseCase : UseCase<ResponseSeriesAPI?> {
    override suspend fun execute(): Result<ResponseSeriesAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getAllSeries()

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }

    }
}