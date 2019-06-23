package pro.mousa.cleanmovies.features.login

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Authenticator
@Inject constructor() {
    fun userLoggedIn() = true
}
