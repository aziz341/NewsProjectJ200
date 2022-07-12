package com.example.movieapp.domain.useCases

import com.example.movieapplication.domain.models.Results
import com.example.movieapplication.domain.repositories.Repository
import retrofit2.Response

class GetPopularMovieeUseCase(private val repository: Repository) {
    suspend fun execute(
        language:String,
        page: Int
    ): Response<Results> {
        return repository.getPopular(language,page)
    }
}