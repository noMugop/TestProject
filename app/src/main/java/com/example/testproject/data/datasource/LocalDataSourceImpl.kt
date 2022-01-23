package com.example.testproject.data.datasource

import com.example.testproject.data.database.GameInfoDao
import com.example.testproject.data.database.GameInfoDatabase
import javax.inject.Inject
import javax.inject.Named

class LocalDataSourceImpl @Inject constructor(
    @Named("gameInfoDatabase") private val gameInfoDatabase: GameInfoDatabase
): LocalDataSource {

    override fun getDatabase(): GameInfoDao {
        return gameInfoDatabase.gameInfoDao()
    }
}