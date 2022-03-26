package com.example.testproject.presentation.adapter.json

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testproject.databinding.ItemGameInfoBinding
import com.example.testproject.databinding.ItemMovieInfoBinding
import com.example.testproject.domain.repository.json.pojo.GameInfo
import com.example.testproject.domain.repository.json.pojo.Movie
import com.squareup.picasso.Picasso

class GameInfoAdapter(private val context: Context) :
    androidx.recyclerview.widget.ListAdapter<Movie, GameInfoViewHolder>(GameInfoDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameInfoViewHolder {
        return GameInfoViewHolder(
            ItemMovieInfoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: GameInfoViewHolder, position: Int) {
        val game = getItem(position)
        with(holder.binding) {
            tvMovieName.text = game.title
            //Picasso.get().load(game.posterPath).into(ivMovieImage)
        }
    }
}