package pro.mousa.cleanmovies.features.movies

import pro.mousa.cleanmovies.core.interactor.UseCase
import pro.mousa.cleanmovies.core.interactor.UseCase.None
import javax.inject.Inject

class GetMovies
@Inject constructor(private val moviesRepository: MoviesRepository) : UseCase<List<Movie>, None>() {

    override suspend fun run(params: None) = moviesRepository.movies()

}
