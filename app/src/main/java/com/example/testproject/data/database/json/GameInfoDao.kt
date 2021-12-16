package com.example.testproject.data.database.json

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.testproject.data.database.json.model.GameInfoDbModel
import com.example.testproject.data.database.json.model.converter.Converters

@Dao
interface GameInfoDao {

    @Query("SELECT * FROM game_info")
    fun getGameInfoList(): LiveData<List<GameInfoDbModel>>

    @Query("SELECT * FROM game_info WHERE id == :id")
    suspend fun getGameInfo(id: Int): GameInfoDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun loadData(list: List<GameInfoDbModel>)
}