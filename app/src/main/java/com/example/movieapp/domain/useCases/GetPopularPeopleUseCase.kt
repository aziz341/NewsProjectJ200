package com.example.movieapp.domain.useCases

import com.example.movieapplication.domain.repositories.Repository

class GetPopularPeopleUseCase (private val repository: Repository){
    suspend fun execute(language: String,page:Int)= repository.getpopularPeople(language,page)
}