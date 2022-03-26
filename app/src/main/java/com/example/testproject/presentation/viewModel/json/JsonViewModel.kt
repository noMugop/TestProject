package com.example.testproject.presentation.viewModel.json

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.domain.repository.json.useCase.GetGameInfoListUseCase
import com.example.testproject.domain.repository.json.useCase.GetGameInfoUseCase
import com.example.testproject.domain.repository.json.useCase.LoadDataUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class JsonViewModel @Inject constructor(
    private val getGameInfoListUseCase: GetGameInfoListUseCase,
    private val getGameInfoUseCase: GetGameInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    val gameInfoLDList = getGameInfoListUseCase()

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