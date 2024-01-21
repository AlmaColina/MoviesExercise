package com.example.movieentrega


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.movieentrega.databinding.MovieDataLayoutBinding

class MovieData : AppCompatActivity(){
    private lateinit var binding: MovieDataLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MovieDataLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val synopsis = intent.getStringExtra("synopsis")
        binding.synopsisData.text = synopsis

        binding.backButton.setOnClickListener { finish() }
    }
}