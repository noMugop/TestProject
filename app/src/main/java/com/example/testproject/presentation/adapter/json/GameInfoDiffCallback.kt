package com.example.testproject.presentation.adapter.json

import androidx.recyclerview.widget.DiffUtil
import com.example.testproject.data.network.json.model.GameInfoDto
import com.example.testproject.domain.repository.json.pojo.GameInfo

object GameInfoDiffCallback: DiffUtil.ItemCallback<GameInfo>() {

    override fun areItemsTheSame(oldItem: GameInfo, newItem: GameInfo): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: GameInfo, newItem: GameInfo): Boolean {
        return oldItem == newItem
    }
}
