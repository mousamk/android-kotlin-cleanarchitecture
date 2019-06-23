package pro.mousa.cleanmovies.features.movies

import android.os.Bundle
import android.view.View
import pro.mousa.cleanmovies.R
import pro.mousa.cleanmovies.core.navigation.Navigator
import pro.mousa.cleanmovies.core.platform.BaseFragment
import javax.inject.Inject

class MoviesFragment : BaseFragment() {

    @Inject lateinit var navigator: Navigator

    override fun layoutId() = R.layout.fragment_movies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
