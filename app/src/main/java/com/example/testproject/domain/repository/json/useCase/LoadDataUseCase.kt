package com.example.testproject.domain.repository.json.useCase

import com.example.testproject.domain.repository.json.JsonRepository
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(private val repository: JsonRepository) {

    suspend operator fun invoke(page: Int) {

        repository.loadData(page)
    }
}