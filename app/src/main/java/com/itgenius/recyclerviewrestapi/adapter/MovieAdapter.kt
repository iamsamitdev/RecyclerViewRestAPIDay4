package com.itgenius.recyclerviewrestapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itgenius.recyclerviewrestapi.databinding.AdapterMovieBinding
import com.itgenius.recyclerviewrestapi.model.MovieModel

class MovieAdapter : RecyclerView.Adapter<MainViewHolder>() {

    // สร้างตัวแปรไว้เก็บรายชื่อหนัง
    var movies = mutableListOf<MovieModel>()

    fun setMovieList(movies: List<MovieModel>){
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.name.text = movie.name
        holder.binding.category.text = movie.category
        holder.binding.desc.text = movie.desc
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}

class MainViewHolder(val binding: AdapterMovieBinding): RecyclerView.ViewHolder(binding.root)