package com.itgenius.recyclerviewrestapi.network

import com.itgenius.recyclerviewrestapi.model.MovieModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    // สร้าง Method สำหรับเรียก API
    @GET("movielist.json")
    fun getAllMovies(): Call<List<MovieModel>>

    // สร้าง Object ของ Retrofit
    companion object {
        // กำหนด BaseURL ของ API
        val BaseURL = "https://howtodoandroid.com/"

        // สร้าง object ของ Retrofit
        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {
            if(retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }

}