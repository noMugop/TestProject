package com.example.testproject.data.network.json

import com.example.testproject.data.network.json.model.GameInfoListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("games")
    suspend fun getGames(
        @Query("key") apiKey: String = "a4e26c0bf94c4e60958070c3e570cd94",
        @Query("page") page: Int = 2,
        @Query("page_size") page_size: Int = 6,
        @Query("platforms") platforms: Int = 4
    ): GameInfoListDto
}