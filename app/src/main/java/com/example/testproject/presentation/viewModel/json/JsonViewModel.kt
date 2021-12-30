package com.example.testproject.presentation.viewModel.json

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.testproject.data.repositoryImpl.JsonRepositoryImpl
import com.example.testproject.domain.repository.json.pojo.GameInfo
import com.example.testproject.domain.repository.json.useCase.GetGameInfoListUseCase
import com.example.testproject.domain.repository.json.useCase.GetGameInfoUseCase
import com.example.testproject.domain.repository.json.useCase.LoadDataUseCase
import javax.inject.Inject

class JsonViewModel @Inject constructor(
    private val getGameInfoListUseCase: GetGameInfoListUseCase,
    private val getGameInfoUseCase: GetGameInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase
    ): ViewModel() {

    fun getGameInfoList() = getGameInfoListUseCase()

    fun getGameInfo(id: Int): GameInfo {
        return getGameInfo(id)
    }

    init {
        loadDataUseCase()
    }
}