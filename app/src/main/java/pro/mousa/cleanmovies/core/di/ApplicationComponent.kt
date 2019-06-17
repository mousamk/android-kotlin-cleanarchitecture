package pro.mousa.cleanmovies.core.di

import dagger.Component
import pro.mousa.cleanmovies.AndroidApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
}
