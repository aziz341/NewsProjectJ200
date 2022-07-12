package com.example.movieapp.presentation.callbacks

import androidx.recyclerview.widget.DiffUtil
import com.example.movieapplication.domain.models.Movie

class MovieDiffCallBack:DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}