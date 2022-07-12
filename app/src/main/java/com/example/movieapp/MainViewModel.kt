package com.example.movieapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.useCases.*
import com.example.movieapplication.data.RepositoryImpl
import com.example.movieapplication.domain.models.Movie
import com.example.movieapplication.domain.repositories.Repository
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.Language
import retrofit2.Response
import retrofit2.http.Query

class MainViewModel : ViewModel() {
    private val repository = RepositoryImpl
    private val getPopularMovieeUseCase = GetPopularMovieeUseCase(repository)
    private val getNowPlayingMoviesUseCase = GetNowPlayingMoviesUseCase(repository)
    private val getTopRateMoviesUseCase = GetTopRateMoviesUseCase(repository)
    private val getUpComingMoviesUseCase = GetUpComingMoviesUseCase(repository)
    private val getSearchMoviesUseCase = GetSearchMoviesUseCase(repository)
    private val GetPopularPeopleUseCase = GetPopularPeopleUseCase(repository)


    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()
    val movies: LiveData<List<Movie>> get() = _movies


    fun getPopularMovies(language: String, page: Int) {
        viewModelScope.launch {
            val response = getPopularMovieeUseCase.execute(language, page)
            if (response.isSuccessful) {
                _movies.value = response.body()?.movies
            }
        }
    }

    fun getTopRateMoviesUseCase(language: String, page: Int) {
        viewModelScope.launch {
            val response = getTopRateMoviesUseCase.execute(language, page)
            if (response.isSuccessful) {
                _movies.value = response.body()?.movies
            }
        }
    }
//    fun getPopularPeople(language: String, page: Int) {
//        viewModelScope.launch {
//            val response = GetPopularPeopleUseCase.execute(language, page)
//            if (response.isSuccessful) {
//                _movies.value = response.body()?.movies
//            }
//        }
//    }

    fun getUpComingMoviesUseCase(language: String, page: Int) {
        viewModelScope.launch {
            val response = getUpComingMoviesUseCase.execute(language, page)
            if (response.isSuccessful) {
                _movies.value = response.body()?.movies
            }
        }
    }
    fun getNowPlayingMoviesUseCase(language: String, page: Int) {
        viewModelScope.launch {
            val response = getNowPlayingMoviesUseCase.execute(language, page)
            if (response.isSuccessful) {
                _movies.value = response.body()?.movies
            }
        }
    }
    fun getSearchMoviesUseCase(language: String, query:String) {
        viewModelScope.launch {
            val response = getSearchMoviesUseCase.execute(language, query)
            if (response.isSuccessful) {
                _movies.value = response.body()?.movies
            }
        }
    }


}