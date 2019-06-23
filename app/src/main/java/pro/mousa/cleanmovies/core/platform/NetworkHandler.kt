package pro.mousa.cleanmovies.core.platform

import android.content.Context
import pro.mousa.cleanmovies.core.extension.networkInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHandler
@Inject constructor(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnectedOrConnecting
}
