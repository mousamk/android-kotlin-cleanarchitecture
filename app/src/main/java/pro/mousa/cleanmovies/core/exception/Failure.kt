package pro.mousa.cleanmovies.core.exception

sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()

    abstract class FeatureFailure: Failure()
}
