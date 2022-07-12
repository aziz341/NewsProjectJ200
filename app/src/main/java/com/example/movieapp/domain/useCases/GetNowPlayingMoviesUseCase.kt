package com.example.movieapp.domain.useCases

import com.example.movieapplication.domain.repositories.Repository
import org.intellij.lang.annotations.Language

class GetNowPlayingMoviesUseCase(private val repository: Repository) {
   suspend fun execute(language: String,page:Int)= repository.getNowPlaying(language,page)
}