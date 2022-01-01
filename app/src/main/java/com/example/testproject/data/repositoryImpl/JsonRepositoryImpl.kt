package com.example.testproject.data.repositoryImpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.testproject.data.database.json.model.GameInfoDbModel
import com.example.testproject.data.datasource.LocalDataSource
import com.example.testproject.data.datasource.RemoteDataSource
import com.example.testproject.data.mapper.GameInfoMapper
import com.example.testproject.domain.repository.json.JsonRepository
import com.example.testproject.domain.repository.json.pojo.GameInfo
import javax.inject.Inject

class JsonRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val mapper: GameInfoMapper
) : JsonRepository {

    override suspend fun getGameInfo(name: String): GameInfo {
        val gameDbModel = localDataSource.getDatabase().getGameInfo(name)
        return mapper.mapDbModelToGameInfo(gameDbModel)
    }

    override suspend fun getGameInfoList(): LiveData<List<GameInfo>> {
        return Transformations.map(localDataSource.getDatabase().getGameInfoList()) {
            it.map { mapper.mapDbModelToGameInfo(it) }
        }
    }

    override suspend fun loadData(page: Int) {
        val gameInfo = remoteDataSource.getApiService().getGames(page = page)
        val listGameInfoDto = gameInfo.results
        if (listGameInfoDto != null) {
            val listGameInfoDbModel = listGameInfoDto.map { mapper.mapDtoToDbModel(it) }
            localDataSource.getDatabase().loadData(listGameInfoDbModel)
        }
    }

    override suspend fun deleteData() {
        localDataSource.getDatabase().deleteData()
    }
}