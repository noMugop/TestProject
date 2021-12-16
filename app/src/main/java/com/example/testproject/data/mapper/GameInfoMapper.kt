package com.example.testproject.data.mapper

import com.example.testproject.data.database.json.model.GameInfoDbModel
import com.example.testproject.data.network.json.model.GameInfoDto
import com.example.testproject.domain.repository.json.pojo.GameInfo

class GameInfoMapper {

    fun mapDtoToDbModel(gameInfoDtoList: GameInfoDto) = GameInfoDbModel(
        id = gameInfoDtoList.id,
        name = gameInfoDtoList.name,
        shortScreenshot = gameInfoDtoList.shortScreenshot)

    fun mapDbModelToGameInfo(gameInfoDbModel: GameInfoDbModel) = GameInfo(
        id = gameInfoDbModel.id,
        name = gameInfoDbModel.name,
        shortScreenshot = gameInfoDbModel.shortScreenshot)

}