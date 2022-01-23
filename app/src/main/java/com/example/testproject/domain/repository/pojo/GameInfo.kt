package com.example.testproject.domain.repository.pojo

data class GameInfo(
    val name: String,
    val backgroundImage: String,
    val shortScreenshot: List<ShortScreenshot>? = null
)