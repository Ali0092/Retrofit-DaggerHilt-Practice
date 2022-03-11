package com.example.practice_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val factory = MainViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        val post = Post(1, 1, "post successfully pushed", "chill.com")

        SetupRecyclerView()
        viewModel.pushingPost(post)

        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
              Toast.makeText(applicationContext,response.body()?.body,Toast.LENGTH_LONG)
                  .show()
            } else {
                Toast.makeText(applicationContext, "Response unsuccessful", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }


    fun SetupRecyclerView() {
        binding.recView.adapter = myadapter
        binding.recView.layoutManager = LinearLayoutManager(this)

    }
}