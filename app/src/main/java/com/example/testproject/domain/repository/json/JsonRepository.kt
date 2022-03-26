package com.example.testproject.domain.repository.json

import androidx.lifecycle.LiveData
import com.example.testproject.domain.repository.json.pojo.Movie

interface JsonRepository {

    fun getGameInfo(id: Int): LiveData<Movie>

    fun getGameInfoList(): LiveData<List<Movie>>

    suspend fun loadData(page: Int)
}