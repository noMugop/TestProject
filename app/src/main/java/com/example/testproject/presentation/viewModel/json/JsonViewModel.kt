package com.example.testproject.presentation.viewModel.json

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.testproject.data.repositoryImpl.JsonRepositoryImpl
import com.example.testproject.domain.repository.json.useCase.GetGameInfoListUseCase
import com.example.testproject.domain.repository.json.useCase.GetGameInfoUseCase
import com.example.testproject.domain.repository.json.useCase.LoadDataUseCase

class JsonViewModel(private val application: Application): ViewModel() {

    private val repository = JsonRepositoryImpl(application)

    private val getGameInfo = GetGameInfoUseCase(repository)
    private val getGameInfoList = GetGameInfoListUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val gameInfoList = getGameInfoList()
    fun gameInfo(id: Int) = getGameInfo(id)

    init {
        loadDataUseCase()
    }
}