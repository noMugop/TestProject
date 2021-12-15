package com.example.testproject.domain.repository.json.useCase

import com.example.testproject.domain.repository.json.JsonRepository

class LoadDataUseCase(private val repositoryImpl: JsonRepository) {

    operator fun invoke() = repositoryImpl.loadData()
}