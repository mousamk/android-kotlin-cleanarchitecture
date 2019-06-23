package pro.mousa.cleanmovies.features.movies

import pro.mousa.cleanmovies.core.exception.Failure
import pro.mousa.cleanmovies.core.exception.Failure.ServerError
import pro.mousa.cleanmovies.core.exception.Failure.NetworkConnection
import pro.mousa.cleanmovies.core.functional.Either
import pro.mousa.cleanmovies.core.functional.Either.Left
import pro.mousa.cleanmovies.core.functional.Either.Right
import pro.mousa.cleanmovies.core.platform.NetworkHandler
import retrofit2.Call
import javax.inject.Inject

interface MoviesRepository {
    fun movies(): Either<Failure, List<Movie>>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler,
                        private val service: MoviesService) : MoviesRepository {
        override fun movies(): Either<Failure, List<Movie>> {
            return when(networkHandler.isConnected) {
                true -> request(service.movies(), { it.map { it.toMovie() } }, emptyList())
                false, null -> Left(NetworkConnection)
            }
        }

        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Right(transform(response.body() ?: default))
                    false -> Left(ServerError)
                }
            } catch (e: Throwable) {
                Left(ServerError)
            }
        }

    }
}
