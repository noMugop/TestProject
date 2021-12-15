package com.example.testproject.domain.repository.json.useCase

import com.example.testproject.domain.repository.json.JsonRepository

class GetGameInfoUseCase(private val repositoryImpl: JsonRepository) {

    operator fun invoke(id: Int) = repositoryImpl.getGameInfo(id)
}