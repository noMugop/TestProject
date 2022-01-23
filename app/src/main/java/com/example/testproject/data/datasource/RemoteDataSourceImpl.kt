package com.example.testproject.data.datasource

import com.example.testproject.data.network.ApiFactory
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiFactory: ApiFactory,
): RemoteDataSource {

    override fun getApiService() = apiFactory.getInstance()
}