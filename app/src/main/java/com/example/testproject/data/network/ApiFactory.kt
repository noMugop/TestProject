package com.example.testproject.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiFactory @Inject constructor(){

    fun getInstance(): ApiService {

        apiService?.let { return it }

        synchronized(LOCK) {
            apiService?.let { return it }

            val instance = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            retrofit = instance
            apiService = instance.create(ApiService::class.java)
            return apiService as ApiService
        }
    }

    companion object {

        private var retrofit: Retrofit? = null

        private var apiService: ApiService? = null

        private const val BASE_URL = "https://api.rawg.io/api/"

        private val LOCK = Any()
    }
}