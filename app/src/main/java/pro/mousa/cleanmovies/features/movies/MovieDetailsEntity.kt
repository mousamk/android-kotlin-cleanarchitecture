package pro.mousa.cleanmovies.features.movies

import pro.mousa.cleanmovies.core.extension.empty

class MovieDetailsEntity(
    private val id: Int,
    private val title: String,
    private val poster: String,
    private val summary: String,
    private val cast: String,
    private val director: String,
    private val year: Int,
    private val trailer: String
) {

    fun toMovieDetails() = MovieDetails(id, title, poster, summary, cast, director, year, trailer)

    companion object {
        fun empty() = MovieDetailsEntity(0, String.empty(), String.empty(), String.empty(), String.empty(),
            String.empty(), 0, String.empty())
    }
}
