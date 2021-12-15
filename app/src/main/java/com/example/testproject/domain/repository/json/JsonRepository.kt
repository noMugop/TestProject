package com.example.testproject.domain.repository.json

import androidx.lifecycle.LiveData
import com.example.testproject.domain.repository.json.pojo.GameInfo

interface JsonRepository {

    fun getGameInfo(id: Int): LiveData<GameInfo>

    fun getGameInfoList(): LiveData<List<GameInfo>>

    fun loadData()
}