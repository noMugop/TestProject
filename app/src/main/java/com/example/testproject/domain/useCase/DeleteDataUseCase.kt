package com.example.testproject.domain.useCase

import com.example.testproject.domain.JsonRepository
import javax.inject.Inject

class DeleteDataUseCase @Inject constructor(private val repository: JsonRepository) {

    suspend operator fun invoke() {

        repository.deleteData()
    }
}