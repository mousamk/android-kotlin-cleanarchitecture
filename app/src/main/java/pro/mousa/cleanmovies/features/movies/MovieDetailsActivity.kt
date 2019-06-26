package pro.mousa.cleanmovies.features.movies

import android.content.Context
import android.content.Intent
import pro.mousa.cleanmovies.BuildConfig
import pro.mousa.cleanmovies.core.platform.BaseActivity

class MovieDetailsActivity : BaseActivity() {

    override fun fragment() =
        MovieDetailsFragment.forMovie(intent.getParcelableExtra(INTENT_EXTRA_PARAM_MOVIE))

    companion object {
        private const val INTENT_EXTRA_PARAM_MOVIE = "${BuildConfig.APPLICATION_ID}.INTENT_PARAM_MOVIE"

        fun callingIntent(context: Context, movie: MovieView): Intent {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(INTENT_EXTRA_PARAM_MOVIE, movie)
            return intent
        }
    }
}
