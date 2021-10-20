package fr.iem.usecase

interface UseCase<out T> {
    suspend fun execute(): Result<T>
}