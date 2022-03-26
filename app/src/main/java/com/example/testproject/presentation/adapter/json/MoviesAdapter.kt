package com.example.testproject.presentation.adapter.json

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testproject.databinding.ItemMovieInfoBinding
import com.example.testproject.domain.repository.json.pojo.Movie
import com.squareup.picasso.Picasso

class MoviesAdapter : ListAdapter<Movie, MovieInfoViewHolder>(MoviesDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieInfoViewHolder {
        return MovieInfoViewHolder(
            ItemMovieInfoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieInfoViewHolder, position: Int) {
        val movie = getItem(position)
        with(holder.binding) {
            tvMovieName.text = movie.title
            Picasso.get().load(IMAGE_URL + movie.posterPath).into(ivMovieImage)
        }
    }

    companion object {

        val IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    }
}