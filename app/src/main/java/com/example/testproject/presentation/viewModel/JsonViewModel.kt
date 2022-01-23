package com.example.testproject.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.domain.useCase.DeleteDataUseCase
import com.example.testproject.domain.useCase.GetGameInfoListUseCase
import com.example.testproject.domain.useCase.GetGameInfoUseCase
import com.example.testproject.domain.useCase.LoadDataUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class JsonViewModel @Inject constructor(
    private val getGameInfoListUseCase: GetGameInfoListUseCase,
    private val getGameInfoUseCase: GetGameInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase,
    private val deleteDataUseCase: DeleteDataUseCase
) : ViewModel() {

    fun getGameInfoList() = getGameInfoListUseCase()

    fun getGameInfo(name: String) = getGameInfoUseCase(name)

    fun loadData(page: Int) {
        viewModelScope.launch {
            loadDataUseCase(page)
        }
    }

    fun deleteData() {
        viewModelScope.launch {
            deleteDataUseCase()
        }
    }

    init {
        deleteData()
        loadData(PAGE)
    }

    companion object {

        var PAGE = 1
    }
}