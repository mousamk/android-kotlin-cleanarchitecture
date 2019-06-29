package pro.mousa.cleanmovies.features.movies

import pro.mousa.cleanmovies.core.interactor.UseCase
import pro.mousa.cleanmovies.features.movies.GetMovieDetails.Params
import javax.inject.Inject

class GetMovieDetails
@Inject constructor(private val moviesRepository: MoviesRepository) : UseCase<MovieDetails, Params>() {

    override suspend fun run(params: Params) = moviesRepository.movieDetails(params.id)

    data class Params(val id: Int)
}
