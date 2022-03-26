package com.example.testproject.presentation.adapter.json

import androidx.recyclerview.widget.DiffUtil
import com.example.testproject.data.network.json.model.GameInfoDto
import com.example.testproject.domain.repository.json.pojo.GameInfo
import com.example.testproject.domain.repository.json.pojo.Movie

object GameInfoDiffCallback: DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}
