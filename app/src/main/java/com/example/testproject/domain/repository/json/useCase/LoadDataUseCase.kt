package com.example.testproject.domain.repository.json.useCase

import com.example.testproject.domain.repository.json.JsonRepository
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(private val repository: JsonRepository) {

    operator fun invoke() = repository.loadData()
}