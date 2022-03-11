package com.example.practice_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice_03.adapter.PostAdapter
import com.example.practice_03.viewModel.MainViewModel
import com.example.practice_03.viewModel.MainViewModelFactory
import com.example.practice_03.databinding.ActivityMainBinding
import com.example.practice_03.model.Post
import com.example.practice_03.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myadapter by lazy { PostAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    val repository=Repository()
    val factory=MainViewModelFactory(repository)
    val viewmodel=ViewModelProvider(this,factory)[MainViewModel::class.java]
      recV()
      viewmodel.getPostlist(1)

            viewmodel.myResponselist.observe(this, Observer { response->
                if(response.isSuccessful){
                    response.body()?.let {  myadapter.DataChanges(it) }
                }
                else{
                    Toast.makeText(applicationContext,"Response unsuccessful",Toast.LENGTH_LONG).show()
                }
            })
        }


    fun recV(){
        binding.recView.adapter=myadapter
        binding.recView.layoutManager=LinearLayoutManager(this)

    }
}