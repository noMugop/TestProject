package com.example.testproject.data.datasource

import com.example.testproject.data.database.json.MoviesDao
import com.example.testproject.data.database.json.MoviesDatabase
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val moviesDatabase: MoviesDatabase
): LocalDataSource {

    override fun getDatabase(): MoviesDao {
        return moviesDatabase.gameInfoDao()
    }
}