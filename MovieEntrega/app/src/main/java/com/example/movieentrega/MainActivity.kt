package com.example.movieentrega

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieentrega.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Arrays

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val movieApiService = retrofit.create(MovieApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        val recyclerView = binding.recyclerViewMovies
        recyclerView.layoutManager =  GridLayoutManager(this, 1)
        CoroutineScope(Dispatchers.IO).launch {
            val moviesList = showMovies()
            runOnUiThread {
                recyclerView.adapter = RecyclerAdapter(moviesList)
            }
        }
    }

    private suspend fun showMovies() : List<Movie> {
        val moviesList  = mutableListOf<Movie>()

        for (page in 1..50) {
            try {
                val response = movieApiService.getTopRatedMovies(
                    apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNzc0ZjIwNjk1OWFmZGM0N2YzYTE0ZGY0N2ZkN2FkNiIsInN1YiI6IjY0N2NiYWM1Y2FlZjJkMDBkZjg5MjFmNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.MzbWdv9BlyGc3b9Mk7qK3qjhsqcYBFBjJkW9Lqn4qBc",
                    language = "es-ES",
                    page = page
                )

                val simplifiedList = response.results.map { movie ->
                    Movie(
                        title = movie.title,
                        release_date = movie.release_date.substring(0, 4),
                        overview = movie.overview,
                        poster_path = "https://image.tmdb.org/t/p/w300_and_h450_bestv2/${movie.poster_path}"
                    )
                }

                moviesList.addAll(simplifiedList)

            } catch (e: Exception) {
                Log.d("Error", e.message.toString())
            }
        }
        return moviesList
    }
}