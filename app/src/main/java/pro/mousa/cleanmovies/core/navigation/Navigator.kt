package pro.mousa.cleanmovies.core.navigation

import android.content.Context
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.ImageView
import pro.mousa.cleanmovies.features.login.Authenticator
import pro.mousa.cleanmovies.features.movies.MovieDetailsActivity
import pro.mousa.cleanmovies.features.movies.MovieView
import pro.mousa.cleanmovies.features.movies.MoviesActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor(private val authenticator: Authenticator) {

    fun showMain(context: Context) {
        when (authenticator.userLoggedIn()) {
            true -> showMovies(context)
//            false -> showLogin(context)
        }
    }

//    private fun showLogin(context: Context) = context.startActivity(LoginActivity.callingIntent(context))

    private fun showMovies(context: Context) = context.startActivity(MoviesActivity.callingIntent(context))

    fun showMovieDetails(activity: FragmentActivity, movie: MovieView, navigationExtras: Extras) {
        val intent = MovieDetailsActivity.callingIntent(activity, movie)
        val sharedView = navigationExtras.transitionSharedElement as ImageView
        val activityOptions =
            ActivityOptionsCompat.makeSceneTransitionAnimation(activity, sharedView, sharedView.transitionName)
        activity.startActivity(intent, activityOptions.toBundle())
    }


    class Extras(val transitionSharedElement: View)
}
