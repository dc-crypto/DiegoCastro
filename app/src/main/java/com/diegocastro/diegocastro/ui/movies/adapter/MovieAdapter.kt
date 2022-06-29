package com.diegocastro.diegocastro.ui.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegocastro.diegocastro.R
import com.diegocastro.diegocastro.domain.model.Movie

class MovieAdapter(
    private val onClickListener: (Movie) -> Unit
) : RecyclerView.Adapter<MovieViewHolder>() {

    private var movies: List<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val v = layoutInflater.inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(v)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movies[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = movies.size

    fun setData(popularMovies: List<Movie>?) {
        movies = popularMovies!!
        notifyDataSetChanged()
    }


}