package pro.mousa.cleanmovies.features.movies

import android.content.Context
import android.content.Intent
import pro.mousa.cleanmovies.core.platform.BaseActivity

class MoviesActivity : BaseActivity() {

    override fun fragment() = MoviesFragment()

    companion object {
        fun callingIntent(context: Context) = Intent(context, MoviesActivity::class.java)
    }

}
