package com.example.testproject.data.datasource

import com.example.testproject.data.network.ApiService

interface RemoteDataSource {

    fun getApiService(): ApiService
}