package com.example.testproject.domain.useCase

import com.example.testproject.domain.JsonRepository
import javax.inject.Inject

class GetGameInfoUseCase @Inject constructor(private val repository: JsonRepository) {

    operator fun invoke(name: String) = repository.getGameInfo(name)
}