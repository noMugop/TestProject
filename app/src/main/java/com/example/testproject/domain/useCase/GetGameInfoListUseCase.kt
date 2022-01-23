package com.example.testproject.domain.useCase

import com.example.testproject.domain.JsonRepository
import javax.inject.Inject

class GetGameInfoListUseCase @Inject constructor(private val repository: JsonRepository) {

    operator fun invoke() = repository.getGameInfoList()
}