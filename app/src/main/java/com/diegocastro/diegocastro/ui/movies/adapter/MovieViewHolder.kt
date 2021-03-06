package com.diegocastro.diegocastro.ui.movies.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.diegocastro.diegocastro.common.Constantes
import com.diegocastro.diegocastro.databinding.ItemMovieBinding
import com.diegocastro.diegocastro.domain.model.Movie

class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemMovieBinding.bind(view)

    fun render(movie: Movie, onClick: (Movie) -> Unit){
        binding.itemMovie.setOnClickListener { onClick(movie) }
        binding.textViewTitle.text = movie.title
        binding.tvRanking.text = movie.vote_average.toString()
        binding.imageViewPhoto.load(Constantes.IMAGE_BASE_URL + movie.poster_path)
        }
    }
