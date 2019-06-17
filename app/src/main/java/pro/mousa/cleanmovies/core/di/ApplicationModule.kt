package pro.mousa.cleanmovies.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import pro.mousa.cleanmovies.AndroidApplication
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: AndroidApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application
}
