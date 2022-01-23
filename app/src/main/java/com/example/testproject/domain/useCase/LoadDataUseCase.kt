package com.example.testproject.domain.useCase

import com.example.testproject.domain.JsonRepository
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(private val repository: JsonRepository) {

    suspend operator fun invoke(page: Int) {

        repository.loadData(page)
    }
}