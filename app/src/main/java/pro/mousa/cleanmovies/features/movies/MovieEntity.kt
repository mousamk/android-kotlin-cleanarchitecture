package pro.mousa.cleanmovies.features.movies

data class MovieEntity(private val id: Int, private val poster: String) {
    fun toMovie() = Movie(id, poster)
}