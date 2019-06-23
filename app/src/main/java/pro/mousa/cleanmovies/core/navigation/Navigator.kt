package pro.mousa.cleanmovies.core.navigation

import android.content.Context
import pro.mousa.cleanmovies.features.login.Authenticator
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

}