package com.marvel.usecase.stories

import com.marvel.model.stories.ResponseStoriesAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetAllStories : UseCase<ResponseStoriesAPI?> {
    override suspend fun execute(): Result<ResponseStoriesAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getAllStories()

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }

    }
}