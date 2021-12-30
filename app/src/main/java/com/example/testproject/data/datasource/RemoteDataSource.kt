package com.example.testproject.data.datasource

import com.example.testproject.data.network.json.ApiFactory
import com.example.testproject.data.network.json.ApiService

interface RemoteDataSource {

    fun getApiService(): ApiService
}