package com.example.testproject.data.database.model

import androidx.room.*
import com.example.testproject.data.database.model.converter.Converters
import com.example.testproject.domain.repository.pojo.ShortScreenshot

@Entity(tableName = "game_info")
@TypeConverters(Converters::class)
data class GameInfoDbModel(
    @PrimaryKey(autoGenerate = false)
    val name: String,

    val backgroundImage: String,

    val shortScreenshot: List<ShortScreenshot>? = null
)

