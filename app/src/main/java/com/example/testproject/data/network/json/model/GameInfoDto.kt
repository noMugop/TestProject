package com.example.testproject.data.network.json.model

import com.example.testproject.domain.repository.json.pojo.ShortScreenshot
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class GameInfoDto(
    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("background_image")
    @Expose
    val backgroundImage: String,

    @SerializedName("short_screenshots")
    @Expose
    val shortScreenshot: List<ShortScreenshot>? = null
)