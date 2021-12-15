package com.example.testproject.presentation.adapter.json

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.testproject.databinding.ItemGameInfoBinding
import com.example.testproject.domain.repository.json.pojo.GameInfo
import com.squareup.picasso.Picasso

class GameInfoAdapter(private val context: Context) :
    androidx.recyclerview.widget.ListAdapter<GameInfo, GameInfoViewHolder>(GameInfoDiffCallback) {

    var onGameClickListener: OnGameClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameInfoViewHolder {
        return GameInfoViewHolder(ItemGameInfoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: GameInfoViewHolder, position: Int) {
        val game = getItem(position)
        with(holder.binding) {
            with(game) {
                tvGameName.text = name
                if (shortScreenshot != null) {
                    Picasso.get().load(shortScreenshot[0].image).into(ivGameImage)
                }
                root.setOnClickListener {
                    onGameClickListener?.onGameClick(this)
                }
            }
        }
    }

    interface OnGameClickListener {
        fun onGameClick(gameInfo: GameInfo)
    }
}