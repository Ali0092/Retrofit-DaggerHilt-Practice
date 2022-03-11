package com.example.practice_03.api

import com.example.practice_03.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost():Response<Post>

    @GET("posts/{numberValue}")
    suspend fun getPostsDynamically(@Path("numberValue") number:Int):Response<Post>

    @GET("posts")
    suspend fun getPostList(
        @Query("userId") userId:Int
    ):Response<List<Post>>

    @PUT("posts/1")
    suspend fun pushPost(
        @Body post: Post
    ):Response<Post>
}