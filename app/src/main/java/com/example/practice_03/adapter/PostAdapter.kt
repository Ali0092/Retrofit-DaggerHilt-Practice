package com.example.practice_03.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice_03.databinding.PostitemsBinding
import com.example.practice_03.model.Post

class PostAdapter():RecyclerView.Adapter<PostAdapter.MyViewHolder>() {
    private var postL= emptyList<Post>()
    class MyViewHolder(val binding:PostitemsBinding):RecyclerView.ViewHolder(binding.root) { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return PostAdapter.MyViewHolder(
            PostitemsBinding.inflate(
             LayoutInflater.from(parent.context),
             parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
           postId.text=postL[position].id.toString()
           postTitle.text=postL[position].title.toString()
        }
    }

    override fun getItemCount(): Int {
        return  postL.size
    }

    //Func.. that notifies the changes in RecyclerView....
    @SuppressLint("NotifyDataSetChanged")
   fun DataChanges(postList:List<Post>){
        this.postL=postList
        this.notifyDataSetChanged()
    }
}