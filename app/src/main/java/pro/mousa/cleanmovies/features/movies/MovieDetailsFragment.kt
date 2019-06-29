package pro.mousa.cleanmovies.features.movies

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_movie_details.*
import kotlinx.android.synthetic.main.row_movie.moviePoster
import kotlinx.android.synthetic.main.toolbar.*
import pro.mousa.cleanmovies.R
import pro.mousa.cleanmovies.core.exception.Failure
import pro.mousa.cleanmovies.core.exception.Failure.*
import pro.mousa.cleanmovies.core.extension.*
import pro.mousa.cleanmovies.core.platform.BaseFragment
import pro.mousa.cleanmovies.features.movies.MovieFailure.*
import javax.inject.Inject

class MovieDetailsFragment : BaseFragment() {

    @Inject lateinit var movieDetailsAnimator: MovieDetailsAnimator
    private lateinit var movieDetailsViewModel: MovieDetailsViewModel

    override fun layoutId() = R.layout.fragment_movie_details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        activity?.let { movieDetailsAnimator.postponeEnterTransition(it) }

        movieDetailsViewModel = viewModel(viewModelFactory) {
            observe(movieDetails, ::renderMovieDetails)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (firstTimeCreated(savedInstanceState)) {
            movieDetailsViewModel.loadMovieDetails((arguments?.get(PARAM_MOVIE) as MovieView).id)
        } else {
            movieDetailsAnimator.scaleUpView(moviePlay)
            movieDetailsAnimator.cancelTransition(moviePoster)
            moviePoster.loadFromUrl((arguments!![PARAM_MOVIE] as MovieView).poster)
        }
    }

    override fun onBackPressed() {
        movieDetailsAnimator.fadeVisible(scrollView, movieDetails)
        if (moviePlay.isVisible())
            movieDetailsAnimator.scaleDownView(moviePlay)
        else
            movieDetailsAnimator.cancelTransition(moviePoster)
    }

    private fun renderMovieDetails(movie: MovieDetailsView?) {
        movie?.let {
            with(movie) {
                activity?.let {
                    moviePoster.loadUrlAndPostponeEnterTransition(poster, it)
                    it.toolbar.title = title
                }
                movieSummary.text = summary
                movieCast.text = cast
                movieDirector.text = director
                movieYear.text = year.toString()
//                moviePlay.setOnClickListener { movieDetailsViewModel.playMovie(trailer) }
            }
        }
        movieDetailsAnimator.fadeVisible(scrollView, movieDetails)
        movieDetailsAnimator.scaleUpView(moviePlay)
    }

    private fun handleFailure(failure: Failure?) {
        when(failure) {
            is NetworkConnection -> { notify(R.string.failure_network_connection); close() }
            is ServerError -> { notify(R.string.failure_server_error); close() }
            is NonExistentMovie -> { notify(R.string.failure_movie_non_existent); close() }
        }
    }

    companion object {
        private const val PARAM_MOVIE = "param_movie"

        fun forMovie(movie: MovieView): MovieDetailsFragment =
             MovieDetailsFragment().apply {
                 arguments = Bundle().apply {
                     putParcelable(PARAM_MOVIE, movie)
                 }
             }
    }
}
