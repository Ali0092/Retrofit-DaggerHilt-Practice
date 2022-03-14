package com.example.practice_03.repository

import com.example.practice_03.api.SimpleApi
import com.example.practice_03.model.Post
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository ( private val api: SimpleApi) {

    suspend fun getPost():Response<Post> {
        return api.getPost()
    }

    suspend fun getPostL(userId:Int):Response<List<Post>>{
        return api.getPostList(userId)
    }

    suspend fun pushPost(post: Post):Response<Post>{
        return api.pushPost(post)
    }
}