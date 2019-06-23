package pro.mousa.cleanmovies.features.movies

import pro.mousa.cleanmovies.core.extension.empty

class Movie(val id: Int, val poster: String) {

    companion object {
        fun empty() = Movie(0, String.empty())
    }
}
