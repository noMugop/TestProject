package com.example.testproject.domain.repository.json.useCase

import com.example.testproject.domain.repository.json.JsonRepository
import javax.inject.Inject

class DeleteDataUseCase @Inject constructor(private val repository: JsonRepository) {

    suspend operator fun invoke() {

        repository.deleteData()
    }
}