package com.example.testproject.data.mapper

import com.example.testproject.data.database.json.model.GameInfoDbModel
import com.example.testproject.data.network.json.model.GameInfoDto
import com.example.testproject.domain.repository.json.pojo.GameInfo
import javax.inject.Inject

class GameInfoMapper @Inject constructor(){

    fun mapDtoToDbModel(gameInfoDtoList: GameInfoDto) = GameInfoDbModel(
        name = gameInfoDtoList.name,
        backgroundImage = gameInfoDtoList.backgroundImage,
        shortScreenshot = gameInfoDtoList.shortScreenshot)

    fun mapDbModelToGameInfo(gameInfoDbModel: GameInfoDbModel) = GameInfo(
        name = gameInfoDbModel.name,
        backgroundImage = gameInfoDbModel.backgroundImage,
        shortScreenshot = gameInfoDbModel.shortScreenshot)

}