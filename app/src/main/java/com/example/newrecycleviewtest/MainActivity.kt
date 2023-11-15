package com.example.newrecycleviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }
    fun setUpRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.adapter = MovieAdapter(getMovies())
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    fun getMovies(): MutableList<Movie>{
        var moviesList:MutableList<Movie> = ArrayList()
        moviesList.add(Movie("AsteroidCity", null))
        moviesList.add(Movie("The French Dispatch", null))
        moviesList.add(Movie("Fantastic Mr Fox", null))
        moviesList.add(Movie("Isle of Dogs", null))
        moviesList.add(Movie("Moonrise Kingdom", null))
        moviesList.add(Movie("The Grand Budapest Hotel", null))
        moviesList.add(Movie("This is an Adventure", null))
        return moviesList
    }
}