package pro.mousa.cleanmovies.features.movies

import pro.mousa.cleanmovies.core.exception.Failure.*

class MovieFailure {
    class ListNotAvailable: FeatureFailure()
    class NonExistentMovie: FeatureFailure()
}
