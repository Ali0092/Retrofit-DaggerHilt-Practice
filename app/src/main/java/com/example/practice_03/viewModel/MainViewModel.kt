package com.example.practice_03.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice_03.model.Post
import com.example.practice_03.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {

    val myResponse:MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponses:MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponselist:MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response=repository.getPost()
            myResponse.value=response
        }
    }
    fun getPosts(num:Int){
        viewModelScope.launch {
            val responses=repository.getPostsD(num)
            myResponses.value=responses
        }
    }

    fun getPostlist(userId:Int){
        viewModelScope.launch {
            myResponselist.value=repository.getPostL(userId)
        }
    }
}