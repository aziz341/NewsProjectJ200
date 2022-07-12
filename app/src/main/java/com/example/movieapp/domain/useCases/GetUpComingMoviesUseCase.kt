package com.example.movieapp.domain.useCases

import com.example.movieapplication.domain.repositories.Repository

class GetUpComingMoviesUseCase(private val repository:Repository) {
    suspend fun execute(language:String,page:Int)=repository.getUpComing(language,page)
}