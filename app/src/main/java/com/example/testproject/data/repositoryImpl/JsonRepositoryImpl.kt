package com.example.testproject.data.repositoryImpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.testproject.data.datasource.LocalDataSource
import com.example.testproject.data.datasource.RemoteDataSource
import com.example.testproject.data.mapper.GameInfoMapper
import com.example.testproject.domain.repository.json.JsonRepository
import com.example.testproject.domain.repository.json.pojo.Movie
import javax.inject.Inject

class JsonRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val mapper: GameInfoMapper
) : JsonRepository {

    override fun getGameInfo(id: Int): LiveData<Movie> {
        return Transformations.map(localDataSource.getDatabase().getGameInfo(id)) {
            mapper.mapDbModelToMovie(it)
        }

    }

    override fun getGameInfoList(): LiveData<List<Movie>> {
        return Transformations.map(localDataSource.getDatabase().getGameInfoList()) {
            it.map { mapper.mapDbModelToMovie(it) }
        }
    }

    override suspend fun loadData(page: Int) {
        val gameInfo = remoteDataSource.getApiService().getMovies(page = page)
        val listGameInfoDto = gameInfo.results
        if (listGameInfoDto != null) {
            val listGameInfoDbModel = listGameInfoDto.map { mapper.mapDtoToDbModelMovie(it) }
            localDataSource.getDatabase().loadData(listGameInfoDbModel)
        }
    }
}