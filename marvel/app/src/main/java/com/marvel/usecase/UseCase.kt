package com.marvel.usecase

interface UseCase<out T> {
    suspend fun execute(): Result<T>
}