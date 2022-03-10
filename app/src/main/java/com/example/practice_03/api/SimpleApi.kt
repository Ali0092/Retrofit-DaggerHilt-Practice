package com.example.practice_03.api

import com.example.practice_03.model.Post
import retrofit2.http.GET

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost():Post
}