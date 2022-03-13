package com.example.practice_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice_03.adapter.PostAdapter
import com.example.practice_03.viewModel.MainViewModel
import com.example.practice_03.databinding.ActivityMainBinding
import com.example.practice_03.model.Post
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myAdapter by lazy { PostAdapter() }
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(1, 1, "post successfully pushed", "chill.com")

        SetupRecyclerView()
        viewModel.pushingPost(post)

        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
              Toast.makeText(applicationContext,"${response.body()?.body}",Toast.LENGTH_LONG)
                  .show()
            } else {
                Toast.makeText(applicationContext, "Response unsuccessful", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }


    fun SetupRecyclerView() {
        binding.recView.adapter = myAdapter
        binding.recView.layoutManager = LinearLayoutManager(this)

    }
}