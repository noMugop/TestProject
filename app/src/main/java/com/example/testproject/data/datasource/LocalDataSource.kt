package com.example.testproject.data.datasource

import com.example.testproject.data.database.json.MoviesDao

interface LocalDataSource {

    fun getDatabase(): MoviesDao
}