package pro.mousa.cleanmovies

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import pro.mousa.cleanmovies.core.di.ApplicationComponent
import pro.mousa.cleanmovies.core.di.ApplicationModule
import pro.mousa.cleanmovies.core.di.DaggerApplicationComponent

class AndroidApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
        this.initializeLeakDetection()
    }

    private fun injectMembers() = appComponent.inject(this)

    private fun initializeLeakDetection() {
        if (BuildConfig.DEBUG) LeakCanary.install(this)
    }
}
