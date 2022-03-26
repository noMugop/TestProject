package com.example.testproject.data.database.json

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.testproject.data.database.json.model.GameInfoDbModel
import com.example.testproject.data.database.json.model.MovieDbModel
import com.example.testproject.data.database.json.model.converter.Converters

@Dao
interface GameInfoDao {

    @Query("SELECT * FROM movie_info")
    fun getGameInfoList(): LiveData<List<MovieDbModel>>

    @Query("SELECT * FROM movie_info WHERE id == :id")
    fun getGameInfo(id: Int): LiveData<MovieDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun loadData(list: List<MovieDbModel>)

    @Query("DELETE FROM movie_info")
    suspend fun deleteData()
}