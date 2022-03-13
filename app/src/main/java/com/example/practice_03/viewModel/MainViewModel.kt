package com.example.practice_03.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice_03.model.Post
import com.example.practice_03.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel
 @Inject constructor(private val repository: Repository) :ViewModel() {

    val myResponse:MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponselist:MutableLiveData<Response<List<Post>>> = MutableLiveData()


    fun getPostlist(userId:Int){
        viewModelScope.launch {
            myResponselist.value=repository.getPostL(userId)
        }
    }

    fun getPost(){
        viewModelScope.launch {
            val response=repository.getPost()
            myResponse.value=response
        }
    }

    fun pushingPost(post:Post){
        viewModelScope.launch {
            myResponse.value=repository.pushPost(post)
        }
    }
}