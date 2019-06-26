package pro.mousa.cleanmovies.features.movies

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_movie.view.*
import pro.mousa.cleanmovies.R
import pro.mousa.cleanmovies.core.extension.inflate
import pro.mousa.cleanmovies.core.extension.loadFromUrl
import pro.mousa.cleanmovies.core.navigation.Navigator
import javax.inject.Inject
import kotlin.properties.Delegates

class MoviesAdapter
@Inject constructor() : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    internal var collection: List<MovieView> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    internal var clickListener: (MovieView, Navigator.Extras) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.row_movie))

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(collection[position], clickListener)


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movieView: MovieView, clickListener: (MovieView, Navigator.Extras) -> Unit) {
            itemView.moviePoster.loadFromUrl(movieView.poster)
            itemView.setOnClickListener { clickListener(movieView, Navigator.Extras(itemView.moviePoster)) }
        }
    }

}
