package com.example.newrecycleviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter (private val mMovies: List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView = itemView.findViewById<TextView>(R.id.movie_name)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent?.context
        val inflater = LayoutInflater.from(context)
        val movieView = inflater.inflate(R.layout.movie_content, parent, false)
        return ViewHolder(movieView)
    }
    override fun getItemCount(): Int {
        return mMovies.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie: Movie = mMovies.get(position)
        val textView = holder.nameTextView
        //Configurar la UI
        textView.text = movie.name
    }
}