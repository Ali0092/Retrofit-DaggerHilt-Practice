package com.example.practice_03.repository

import com.example.practice_03.model.Post
import com.example.practice_03.retrofirInst.RetrofitInstance
import retrofit2.Response
import retrofit2.http.POST

class Repository {

    suspend fun getPost():Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPostsD(number:Int):Response<Post>{
        return RetrofitInstance.api.getPostsDynamically(number)
    }

    suspend fun getPostL(userId:Int):Response<List<Post>>{
        return RetrofitInstance.api.getPostList(userId)
    }
}