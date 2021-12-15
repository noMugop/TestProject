package com.example.testproject.data.repositoryImpl

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.testproject.data.database.json.GameInfoDatabase
import com.example.testproject.data.database.json.model.GameInfoDbModel
import com.example.testproject.data.mapper.GameInfoMapper
import com.example.testproject.data.network.json.ApiFactory
import com.example.testproject.domain.repository.json.JsonRepository
import com.example.testproject.domain.repository.json.pojo.GameInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JsonRepositoryImpl(application: Application) : JsonRepository {

    private val scope = CoroutineScope(Dispatchers.Main)
    private val apiService = ApiFactory.apiService
    private val db = GameInfoDatabase.getInstance(application).gameInfoDao()
    private val mapper = GameInfoMapper()

    override fun getGameInfo(id: Int): LiveData<GameInfo> {
        TODO()
    }

    override fun getGameInfoList(): LiveData<List<GameInfo>> {
        return Transformations.map(db.getGameInfoList()) {
            it.map { mapper.mapDbModelToGameInfo(it) }
        }
    }

    override fun loadData() {
        scope.launch {
            var listGameInfoDbModel = listOf<GameInfoDbModel>()
            val gameInfo = apiService.getGames()
            val listGameInfoDto = gameInfo.results
            if (listGameInfoDto != null) {
                listGameInfoDbModel = listGameInfoDto.map { mapper.mapDtoToDbModel(it) }
            }
            db.loadData(listGameInfoDbModel)
        }
    }
}