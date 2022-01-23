package com.example.testproject.data.repositoryImpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.testproject.data.database.GameInfoDao
import com.example.testproject.data.datasource.RemoteDataSource
import com.example.testproject.data.mapper.GameInfoMapper
import com.example.testproject.domain.JsonRepository
import com.example.testproject.domain.repository.pojo.GameInfo
import javax.inject.Inject

class JsonRepositoryImpl @Inject constructor(
    private val gameInfoDao: GameInfoDao,
    private val remoteDataSource: RemoteDataSource,
    private val mapper: GameInfoMapper
) : JsonRepository {

    override fun getGameInfo(name: String): LiveData<GameInfo> {
        return Transformations.map(gameInfoDao.getGameInfo(name)) {
            mapper.mapDbModelToGameInfo(it)
        }
    }

    override fun getGameInfoList(): LiveData<List<GameInfo>> {
        return Transformations.map(gameInfoDao.getGameInfoList()) {
            it.map { mapper.mapDbModelToGameInfo(it) }
        }
    }

    override suspend fun loadData(page: Int) {
        val gameInfo = remoteDataSource.getApiService().getGames(page = page)
        val listGameInfoDto = gameInfo.results
        if (listGameInfoDto != null) {
            val listGameInfoDbModel = listGameInfoDto.map { mapper.mapDtoToDbModel(it) }
            gameInfoDao.loadData(listGameInfoDbModel)
        }
    }

    override suspend fun deleteData() {
        gameInfoDao.deleteData()
    }
}