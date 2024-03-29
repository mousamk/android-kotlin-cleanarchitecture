package pro.mousa.cleanmovies.features.movies

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {

    @GET(MOVIES) fun movies(): Call<List<MovieEntity>>
    @GET(MOVIE_DETAILS) fun movieDetails(@Path(PARAM_MOVIE_ID) movieId: Int): Call<MovieDetailsEntity>

    companion object {
        private const val PARAM_MOVIE_ID = "movieId"
        private const val MOVIES = "movies.json"
        private const val MOVIE_DETAILS = "movie_0{$PARAM_MOVIE_ID}.json"
    }
}
