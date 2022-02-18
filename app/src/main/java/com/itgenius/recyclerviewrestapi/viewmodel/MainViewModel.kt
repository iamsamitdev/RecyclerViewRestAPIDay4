package com.itgenius.recyclerviewrestapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itgenius.recyclerviewrestapi.model.MovieModel
import com.itgenius.recyclerviewrestapi.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel(){

    val movieList = MutableLiveData<List<MovieModel>>()
    val errorMessage = MutableLiveData<String>()

    // ส้ร้างฟังก์ชันดึงรายชื่อหนัง
    fun getAllMovies(){
        val response = repository.getAllMovies()
        response.enqueue(object: Callback<List<MovieModel>>{

            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }

}