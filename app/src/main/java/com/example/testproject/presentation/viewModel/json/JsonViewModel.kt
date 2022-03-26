package com.example.testproject.presentation.viewModel.json

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.domain.repository.json.useCase.GetMoviesListUseCase
import com.example.testproject.domain.repository.json.useCase.GetMoviesUseCase
import com.example.testproject.domain.repository.json.useCase.LoadDataUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class JsonViewModel @Inject constructor(
    private val getMoviesListUseCase: GetMoviesListUseCase,
    private val getMoviesUseCase: GetMoviesUseCase,
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    val moviesLit = getMoviesListUseCase()

    fun loadData(page: Int) {
        viewModelScope.launch {
            loadDataUseCase(page)
        }
    }

    init {
        loadData(PAGE)
    }

    companion object {

        var PAGE = 1
    }
}