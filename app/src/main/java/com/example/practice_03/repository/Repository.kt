package com.example.practice_03.repository

import com.example.practice_03.model.Post
import com.example.practice_03.retrofirInst.RetrofitInstance

class Repository {

    suspend fun getPost():Post{
        return RetrofitInstance.api.getPost()
    }
}