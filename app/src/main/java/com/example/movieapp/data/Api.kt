package com.example.movieapplication.data

import com.example.movieapp.domain.models.People
import com.example.movieapplication.domain.models.Movie
import com.example.movieapplication.domain.models.Results
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("movie/popular")
    suspend fun getPopular(
        @Query("api_key") apiKey:String?,
        @Query("language") language: String,
        @Query("page") page:Int?
    ): Response<Results>

    @GET("movie/top_rated")
    suspend fun getTops(
        @Query("api_key") apiKey:String?,
        @Query("language") language:String?,
        @Query("page") page:Int?
    ): Response<Results>

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("api_key") apiKey:String?,
        @Query("language") language:String?,
        @Query("page") page:Int?
    ): Response<Results>

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey:String?,
        @Query("language") language:String?,
        @Query("page") page:Int?
    ): Response<Results>

    @GET("search/movie")
    suspend fun search(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("query") query: String?
    ): Response<Results>

    @GET("person/popular")
    suspend fun getPersonPopular(
        @Query("api_key") apiKey:String,
        @Query("page") page: String,
        @Query("language") language: Int
    ): Response<People>
}