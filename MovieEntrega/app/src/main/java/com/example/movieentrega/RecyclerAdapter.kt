package com.example.movieentrega

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapter(var movies : List<Movie>) : RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MoviesViewHolder(layoutInflater.inflate(R.layout.movie_layout, parent, false))
    }
    override fun getItemCount(): Int {
        return movies.size
    }
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = movies[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context, MovieData::class.java)
            intent.putExtra("synopsis", item.overview)
            context.startActivity(intent)
        }
    }
}