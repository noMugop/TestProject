package com.example.testproject.domain.repository.json.useCase

import com.example.testproject.domain.repository.json.JsonRepository

class GetGameInfoListUseCase(private val repositoryImpl: JsonRepository) {

    operator fun invoke() = repositoryImpl.getGameInfoList()
}