package com.example.testproject.domain.repository.json

import androidx.lifecycle.LiveData
import com.example.testproject.domain.repository.json.pojo.GameInfo

interface JsonRepository {

    suspend fun getGameInfo(name: String): GameInfo

    suspend fun getGameInfoList(): LiveData<List<GameInfo>>

    suspend fun loadData(page: Int)

    suspend fun deleteData()
}