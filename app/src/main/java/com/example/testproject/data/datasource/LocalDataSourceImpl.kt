package com.example.testproject.data.datasource

import android.app.Application
import com.example.testproject.data.database.json.GameInfoDao
import com.example.testproject.data.database.json.GameInfoDatabase
import com.example.testproject.data.network.json.ApiFactory
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val application: Application,
    private val gameInfoDatabase: GameInfoDatabase
): LocalDataSource {

    override fun getDatabase() = gameInfoDatabase.getInstance(application).gameInfoDao()

}