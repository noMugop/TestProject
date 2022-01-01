package com.example.testproject.domain.repository.json.useCase

import com.example.testproject.domain.repository.json.JsonRepository
import javax.inject.Inject

class GetGameInfoUseCase @Inject constructor(private val repository: JsonRepository) {

    suspend operator fun invoke(name: String) = repository.getGameInfo(name)
}