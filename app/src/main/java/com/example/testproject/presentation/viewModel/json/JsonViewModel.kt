package com.example.testproject.presentation.viewModel.json

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.data.repositoryImpl.JsonRepositoryImpl
import com.example.testproject.domain.repository.json.pojo.GameInfo
import com.example.testproject.domain.repository.json.useCase.DeleteDataUseCase
import com.example.testproject.domain.repository.json.useCase.GetGameInfoListUseCase
import com.example.testproject.domain.repository.json.useCase.GetGameInfoUseCase
import com.example.testproject.domain.repository.json.useCase.LoadDataUseCase
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