package com.example.movieapp.domain.useCases

import com.example.movieapplication.domain.repositories.Repository

class GetTopRateMoviesUseCase(private val repository: Repository) {
    suspend fun execute(language:String,page:Int)=repository.getTopRated(language,page)
}