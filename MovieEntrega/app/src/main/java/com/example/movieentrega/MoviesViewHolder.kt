package com.example.movieentrega

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieentrega.databinding.MovieLayoutBinding

class MoviesViewHolder (view : View) : RecyclerView.ViewHolder(view)  {
    val binding = MovieLayoutBinding.bind(view)
    fun bind(movie : Movie){
        binding.MovieName.text = movie.title
        binding.MovieYear.text = movie.release_date
        Glide.with(binding.poster.context).load(movie.poster_path).into(binding.poster)
    }
}