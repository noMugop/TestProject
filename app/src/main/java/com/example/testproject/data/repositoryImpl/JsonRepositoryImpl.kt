package com.example.testproject.data.repositoryImpl

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.testproject.data.database.json.GameInfoDatabase
import com.example.testproject.data.database.json.model.GameInfoDbModel
import com.example.testproject.data.datasource.LocalDataSource
import com.example.testproject.data.datasource.RemoteDataSource
import com.example.testproject.data.mapper.GameInfoMapper
import com.example.testproject.data.network.json.ApiFactory
import com.example.testproject.data.network.json.ApiService
import com.example.testproject.domain.repository.json.JsonRepository
import com.example.testproject.domain.repository.json.pojo.GameInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class JsonRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val mapper: GameInfoMapper
) : JsonRepository {

    private val scope = CoroutineScope(Dispatchers.Main)

    override fun getGameInfo(id: Int): GameInfo {
        var game: GameInfo? = null
        scope.launch {
            val gameDbModel = localDataSource.getDatabase().getGameInfo(id)
            game = mapper.mapDbModelToGameInfo(gameDbModel)
        }
            return game as GameInfo
    }

    override fun getGameInfoList(): LiveData<List<GameInfo>> {
        return Transformations.map(localDataSource.getDatabase().getGameInfoList()) {
            it.map { mapper.mapDbModelToGameInfo(it) }
        }
    }

    override fun loadData() {
        scope.launch {
            var listGameInfoDbModel = listOf<GameInfoDbModel>()
            val gameInfo = remoteDataSource.getApiService().getGames()
            val listGameInfoDto = gameInfo.results
            if (listGameInfoDto != null) {
                listGameInfoDbModel = listGameInfoDto.map { mapper.mapDtoToDbModel(it) }
            }
            localDataSource.getDatabase().loadData(listGameInfoDbModel)
        }
    }
}