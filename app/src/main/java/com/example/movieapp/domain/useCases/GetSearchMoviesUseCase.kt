package com.example.movieapp.domain.useCases

import com.example.movieapplication.domain.repositories.Repository

class GetSearchMoviesUseCase(private val repository: Repository) {
    suspend fun execute(language: String,query:String)= repository.searchMovie(language,query)
}