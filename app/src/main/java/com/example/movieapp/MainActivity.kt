package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.presentation.adapters.MovieAdapter

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,SearchView.OnQueryTextListener{
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapter : MovieAdapter by lazy {
        MovieAdapter()
    }
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
        )[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.mainRv.hasFixedSize()
        viewModel.movies.observe(this) {
            adapter.submitList(it)
        }
        binding.mainRv.adapter = adapter
        viewModel.getPopularMovies("en", 1)

        val arrayAdapter =
            ArrayAdapter.createFromResource(this, R.array.movie_categories, R.layout.spinner_item)
        binding.searchView.setOnQueryTextListener(this)
        binding.spinner.apply {
            adapter = arrayAdapter
            onItemSelectedListener = this@MainActivity
        }

    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        when (position) {
            0 -> viewModel.getPopularMovies(language = "ru", 1)
            1 -> viewModel.getNowPlayingMoviesUseCase("ru", 1)
            2 -> viewModel.getTopRateMoviesUseCase("ru", 1)
            3 -> viewModel.getUpComingMoviesUseCase("ru", 1)
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) = Unit
    override fun onQueryTextSubmit(searchText: String?): Boolean {
        if (searchText!=null){
            viewModel.getSearchMoviesUseCase("ru",searchText)
        }
        return false

    }

    override fun onQueryTextChange(searchText: String?): Boolean {
        if (searchText!=null)  viewModel.getSearchMoviesUseCase("ru",searchText)
        else viewModel.getPopularMovies(language = "ru",1)
        return false

    }
}