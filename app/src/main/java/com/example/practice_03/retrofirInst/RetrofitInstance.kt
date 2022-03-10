package com.example.practice_03.retrofirInst

import com.example.practice_03.api.SimpleApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private const val BASE_URL="http://jsonplaceholder.typicode.com"

    val api:SimpleApi by lazy {
            Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SimpleApi::class.java)
    }
}