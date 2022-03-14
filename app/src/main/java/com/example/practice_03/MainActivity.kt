package com.example.practice_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice_03.adapter.PostAdapter
import com.example.practice_03.viewModel.MainViewModel
import com.example.practice_03.databinding.ActivityMainBinding
import com.example.practice_03.model.Post
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //Variables Declaration....
    private lateinit var binding: ActivityMainBinding
    private val myAdapter by lazy { PostAdapter() }
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        SetupRecyclerView()

        //Getting Data From web Server..
        viewModel.getPostlist(1)
        //Observing ViewModel LiveData....
        viewModel.myResponseList.observe(this, Observer { response ->
            if (response.isSuccessful) {
                //Assigning List of Post type Variables to the RecyclerView Adapter..
                response.body()?.let { myAdapter.DataChanges(it) }
            } else {
                Toast.makeText(applicationContext, "Response unsuccessful", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    //Func. to Initializing RecyclerView....
    private fun SetupRecyclerView() {
        binding.recView.adapter = myAdapter
        binding.recView.layoutManager = LinearLayoutManager(this)

    }
}