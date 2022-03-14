package com.example.practice_03.model

//Model or Data Class that is according to the format of JSON..

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)