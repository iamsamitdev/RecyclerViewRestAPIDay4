package com.itgenius.recyclerviewrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.itgenius.recyclerviewrestapi.adapter.MovieAdapter
import com.itgenius.recyclerviewrestapi.databinding.ActivityMovieBinding
import com.itgenius.recyclerviewrestapi.network.RetrofitService
import com.itgenius.recyclerviewrestapi.repository.MainRepository
import com.itgenius.recyclerviewrestapi.viewmodel.MainViewModel
import com.itgenius.recyclerviewrestapi.viewmodelfactory.MainViewModelFactory

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // เรียก ViewModel มาใช้งาน
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(MainRepository(retrofitService)))
            .get(MainViewModel::class.java)

        // binding adapter เข้าไปยัง View
        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this, Observer {
            adapter.setMovieList(it)
        })

        viewModel.errorMessage.observe(this, Observer {

        })

        viewModel.getAllMovies()
    }
}