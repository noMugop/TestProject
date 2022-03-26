package com.example.testproject.presentation.adapter.json

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testproject.databinding.ItemMovieInfoBinding
import com.example.testproject.domain.repository.json.pojo.Movie

class MoviesAdapter : ListAdapter<Movie, MovieInfoViewHolder>(MoviesDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieInfoViewHolder {
        return MovieInfoViewHolder(
            ItemMovieInfoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieInfoViewHolder, position: Int) {
        val game = getItem(position)
        with(holder.binding) {
            tvMovieName.text = game.title
            //Picasso.get().load(game.posterPath).into(ivMovieImage)
        }
    }
}