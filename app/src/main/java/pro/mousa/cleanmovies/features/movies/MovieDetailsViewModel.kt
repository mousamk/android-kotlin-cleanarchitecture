package pro.mousa.cleanmovies.features.movies

import android.arch.lifecycle.MutableLiveData
import pro.mousa.cleanmovies.core.platform.BaseViewModel
import pro.mousa.cleanmovies.features.movies.GetMovieDetails.Params
import javax.inject.Inject

class MovieDetailsViewModel
@Inject constructor(private val getMovieDetails: GetMovieDetails) : BaseViewModel() {

    var movieDetails: MutableLiveData<MovieDetailsView> = MutableLiveData()

    fun loadMovieDetails(movieId: Int) =
        getMovieDetails(Params(movieId)) { it.either(::handleFailure, ::handleMovieDetails) }

    private fun handleMovieDetails(movie: MovieDetails) {
        this.movieDetails.value = MovieDetailsView(movie.id, movie.title, movie.poster, movie.summary,
            movie.cast, movie.director, movie.year, movie.trailer)
    }

}
