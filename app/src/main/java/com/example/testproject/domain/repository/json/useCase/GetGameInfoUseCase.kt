package com.example.testproject.domain.repository.json.useCase

import com.example.testproject.domain.repository.json.JsonRepository
import javax.inject.Inject

class GetGameInfoUseCase @Inject constructor(private val repository: JsonRepository) {

    operator fun invoke(id: Int) = repository.getGameInfo(id)
}