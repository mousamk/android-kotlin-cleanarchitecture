package pro.mousa.cleanmovies.core.di

import dagger.Component
import pro.mousa.cleanmovies.AndroidApplication
import pro.mousa.cleanmovies.core.di.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
}
