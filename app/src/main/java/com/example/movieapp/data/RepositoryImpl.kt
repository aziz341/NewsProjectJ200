package com.example.movieapplication.data

import com.example.movieapp.domain.models.People
import com.example.movieapplication.domain.Utils
import com.example.movieapplication.domain.models.Results
import com.example.movieapplication.domain.repositories.Repository
import retrofit2.Response

object RepositoryImpl : Repository {
    override suspend fun getPopular(
        language: String,
        page: Int
    ): Response<Results> {
        return RetrofitInstance.api.getPopular(Utils.API_KEY,language,page)
    }

    override suspend fun getTopRated(
        language: String,
        page: Int
    ): Response<Results> {
        return RetrofitInstance.api.getTops(Utils.API_KEY,language, page)
    }

    override suspend fun getUpComing(
        language: String,
        page: Int
    ): Response<Results> {
        return RetrofitInstance.api.getUpcoming( Utils.API_KEY,language, page)
    }

    override suspend fun getNowPlaying(
        language: String,
        page: Int
    ): Response<Results> {
        return RetrofitInstance.api.getNowPlaying(Utils.API_KEY,language, page)
    }

    override suspend fun searchMovie(
        language: String,
        query: String
    ): Response<Results> = RetrofitInstance.api.search(Utils.API_KEY,language,query)

    override suspend fun getpopularPeople(
        language: String,
        page: Int
    ): Response<People> {
        return RetrofitInstance.api.getPersonPopular(Utils.API_KEY, language,page)

    }
}