package com.marvel.usecase.event

import com.marvel.model.event.ResponseEventsAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetAllEventsUseCase : UseCase<ResponseEventsAPI?> {
    override suspend fun execute(): Result<ResponseEventsAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getAllEvents()

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}
