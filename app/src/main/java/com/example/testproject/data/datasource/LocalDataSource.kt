package com.example.testproject.data.datasource

import com.example.testproject.data.database.GameInfoDao

interface LocalDataSource {

    fun getDatabase(): GameInfoDao
}