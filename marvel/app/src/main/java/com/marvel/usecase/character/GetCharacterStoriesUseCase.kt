package com.marvel.usecase.character

import com.marvel.modele.series.ResponseSeriesAPI
import com.marvel.modele.stories.ResponseStoriesAPI
import com.marvel.network.ApiClientMarvel
import com.marvel.usecase.UseCase

class GetCharacterStoriesUseCase (private val id: String) : UseCase<ResponseStoriesAPI?> {

    override suspend fun execute(): Result<ResponseStoriesAPI?> {
        return try {
            val response = ApiClientMarvel.apiServiceMarvel.getCharacterStories(id)

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}