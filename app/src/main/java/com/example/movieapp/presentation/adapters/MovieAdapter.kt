package com.example.movieapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.movieapp.R
import com.example.movieapp.databinding.MovieBinding
import com.example.movieapp.presentation.callbacks.MovieDiffCallBack
import com.example.movieapp.presentation.viewHolders.MovieViewHolder
import com.example.movieapplication.domain.models.Movie

class MovieAdapter :ListAdapter<Movie,MovieViewHolder>(MovieDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            MovieBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.movie, parent, false)

            )
        )


        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            holder.bind(getItem(position))

        }
    }
