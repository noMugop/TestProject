package com.example.testproject.data.datasource

import com.example.testproject.data.network.json.ApiFactory
import com.example.testproject.data.network.json.ApiService
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiFactory: ApiFactory,
): RemoteDataSource {

    override fun getApiService() = apiFactory.getInstance()
}