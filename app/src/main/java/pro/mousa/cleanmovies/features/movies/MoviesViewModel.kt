package pro.mousa.cleanmovies.features.movies

import android.arch.lifecycle.MutableLiveData
import pro.mousa.cleanmovies.core.interactor.UseCase.*
import pro.mousa.cleanmovies.core.platform.BaseViewModel
import javax.inject.Inject

class MoviesViewModel
@Inject constructor(private val getMovies: GetMovies) : BaseViewModel() {

    var movies: MutableLiveData<List<MovieView>> = MutableLiveData()

    fun loadMovies() = getMovies(None()) { it.either(::handleFailure, ::handleMovieList) }

    private fun handleMovieList(movies: List<Movie>) {
        this.movies.value = movies.map { MovieView(it.id, it.poster) }
    }
}
