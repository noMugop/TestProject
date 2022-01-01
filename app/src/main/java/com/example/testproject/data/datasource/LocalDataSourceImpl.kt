package com.example.testproject.data.datasource

import android.app.Application
import com.example.testproject.data.database.json.GameInfoDao
import com.example.testproject.data.database.json.GameInfoDatabase
import com.example.testproject.data.network.json.ApiFactory
import javax.inject.Inject
import javax.inject.Named

class LocalDataSourceImpl @Inject constructor(
    @Named("gameInfoDatabase") private val gameInfoDatabase: GameInfoDatabase
): LocalDataSource {

    override fun getDatabase(): GameInfoDao {
        return gameInfoDatabase.gameInfoDao()
    }
}