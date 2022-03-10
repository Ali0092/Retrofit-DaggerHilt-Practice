package com.example.practice_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.practice_03.viewModel.MainViewModel
import com.example.practice_03.viewModel.MainViewModelFactory
import com.example.practice_03.databinding.ActivityMainBinding
import com.example.practice_03.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    val repository=Repository()
    val factory=MainViewModelFactory(repository)
    val viewmodel=ViewModelProvider(this,factory)[MainViewModel::class.java]
        viewmodel.getPost()
        viewmodel.myResponse.observe(this,
        Observer {  Respo->
            Log.d("Response",Respo.userId.toString())
            Log.d("Response",Respo.id.toString())
            Log.d("Response",Respo.title.toString())
            Log.d("Response",Respo.body.toString())
        })

    }
}