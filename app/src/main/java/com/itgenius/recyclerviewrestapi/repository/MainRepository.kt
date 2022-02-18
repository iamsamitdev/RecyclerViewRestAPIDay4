package com.itgenius.recyclerviewrestapi.repository

import com.itgenius.recyclerviewrestapi.network.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    // เก็บ Rest API Method จาก RetrofitService ทั้งหมดไว้ที่นี่
    fun getAllMovies() = retrofitService.getAllMovies()

}