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
class MainViewModel //Injecting Repository into the ViewModel Class.....
 @Inject constructor(private val repository: Repository) :ViewModel() {

    val myResponse:MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponseList:MutableLiveData<Response<List<Post>>> = MutableLiveData()

    //Getting list of Responses of same ID..
    fun getPostlist(userId:Int){
        viewModelScope.launch {
            myResponseList.value=repository.getPostL(userId)
        }
    }

    //Getting Single Response..
    fun getPost(){
        viewModelScope.launch {
            val response=repository.getPost()
            myResponse.value=response
        }
    }

    //Pushing Single instance to the Server..
    fun pushingPost(post:Post){
        viewModelScope.launch {
            myResponse.value=repository.pushPost(post)
        }
    }
}