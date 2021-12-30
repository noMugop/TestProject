package com.example.testproject.data.datasource

import com.example.testproject.data.database.json.GameInfoDao
import com.example.testproject.data.database.json.GameInfoDatabase

interface LocalDataSource {

    fun getDatabase(): GameInfoDao
}