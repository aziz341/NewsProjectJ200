package com.example.movieapp.presentation.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.MovieBinding
import com.example.movieapplication.domain.Utils
import com.example.movieapplication.domain.models.Movie
import com.squareup.picasso.Picasso

class MovieViewHolder(
    val binding: MovieBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) = binding.apply {
//        val voteAverage = movie.rating * 10
//        if (voteAverage.toInt() > 70) {
//            binding.progressView.setProgressColor(R.color.green)
//        }
        Picasso.get().load(Utils.POSTER_PATH_URL + movie.posterPath).into(binding.movieImage)
//        binding.progressView.setProgress(voteAverage.toInt(), true)
    }
}
