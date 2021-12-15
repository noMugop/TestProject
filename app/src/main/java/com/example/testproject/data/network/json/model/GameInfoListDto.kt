package com.example.testproject.data.network.json.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class GameInfoListDto(
    @SerializedName("results")
    @Expose
    val results: List<GameInfoDto>? = null)