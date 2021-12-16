package com.example.testproject.data.database.json.model

import androidx.room.*
import com.example.testproject.data.database.json.model.converter.Converters
import com.example.testproject.domain.repository.json.pojo.ShortScreenshot

@Entity(tableName = "game_info")
@TypeConverters(Converters::class)
data class GameInfoDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String,

    val shortScreenshot: List<ShortScreenshot>? = null
)

