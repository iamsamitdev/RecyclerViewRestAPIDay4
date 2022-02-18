package com.itgenius.recyclerviewrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itgenius.recyclerviewrestapi.adapter.RecyclerViewAdapter
import com.itgenius.recyclerviewrestapi.databinding.ActivityMainBinding
import com.itgenius.recyclerviewrestapi.model.ProductModel
import com.itgenius.recyclerviewrestapi.network.RetrofitService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // เรียกใช้ binding view
    private lateinit var binding: ActivityMainBinding

    // เรียกใช้ Adapter
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    // เรียกใช้ Model
    private lateinit var productList: List<ProductModel>

    // ทดสอบเรียกใช้ Retrofit Service
    private val retrofitService = RetrofitService.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // load data to Product List
        loadProduct()

        // create  layoutManager
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

        // pass it to recyclerView layoutManager
       binding.recyclerView.setLayoutManager(layoutManager)

        // initialize the adapter
        recyclerViewAdapter = RecyclerViewAdapter(productList)

        // attach adapter to the recycler view
        binding.recyclerView.adapter = recyclerViewAdapter

        // ทดสอบเรียกใช้งาน Retrofit Rest API
        // GlobalScope จะเป็นฟังก์ชันการทำงานแบบ Asynchronous
        /*
        GlobalScope.launch {
            val result = retrofitService.getAllMovies()
            val data = result.body()
            Log.d("MovieData:", data.toString())
        }
         */

    }

    // เขียนฟังก์ชันเพิ่มข้อมูลงใน Model
    private fun loadProduct(){
        productList = listOf(
            ProductModel("iPhone 13 Pro Max", "Description of iphone 13") ,
            ProductModel("iPad 2021 Air", "Description of iPad 2021 Air"),
            ProductModel("Samsung S22", "Description of iPad Samsung S22"),
            ProductModel("Huawei P30", "Description of iPad Huawei P30"),
            ProductModel("Sony Cybershot", "Description of Sony Cybershot"),
            ProductModel("iPhone 13 Pro Max", "Description of iphone 13") ,
            ProductModel("iPad 2021 Air", "Description of iPad 2021 Air"),
            ProductModel("Samsung S22", "Description of iPad Samsung S22"),
            ProductModel("Huawei P30", "Description of iPad Huawei P30"),
            ProductModel("Sony Cybershot", "Description of Sony Cybershot"),
            ProductModel("iPhone 13 Pro Max", "Description of iphone 13") ,
            ProductModel("iPad 2021 Air", "Description of iPad 2021 Air"),
            ProductModel("Samsung S22", "Description of iPad Samsung S22"),
            ProductModel("Huawei P30", "Description of iPad Huawei P30"),
            ProductModel("Sony Cybershot", "Description of Sony Cybershot")
        )
    }

}