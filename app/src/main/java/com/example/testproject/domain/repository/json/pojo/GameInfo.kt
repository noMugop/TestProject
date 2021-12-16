package com.example.testproject.domain.repository.json.pojo

data class GameInfo(
    val id: Int,
    val name: String,
    val shortScreenshot: List<ShortScreenshot>? = null
)