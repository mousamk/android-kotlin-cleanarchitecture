package pro.mousa.cleanmovies.core.di

import dagger.Component
import pro.mousa.cleanmovies.AndroidApplication
import pro.mousa.cleanmovies.core.di.viewmodel.ViewModelModule
import pro.mousa.cleanmovies.core.navigation.RouteActivity
import pro.mousa.cleanmovies.features.movies.MovieDetailsFragment
import pro.mousa.cleanmovies.features.movies.MoviesFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
    fun inject(routeActivity: RouteActivity)
    fun inject(moviesFragment: MoviesFragment)
    fun inject(movieDetailsFragment: MovieDetailsFragment)
}
