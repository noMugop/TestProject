package com.example.testproject.data.network.json.model

import com.example.testproject.domain.repository.json.pojo.ShortScreenshot
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class GameInfoDto(
    val id: Int = UNDEFINED_ID,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("short_screenshots")
    @Expose
    val shortScreenshot: List<ShortScreenshot>? = null
) {

    companion object {

        const val UNDEFINED_ID = 0
    }
}