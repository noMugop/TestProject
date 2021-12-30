package com.example.testproject.presentation.viewModel.json

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.domain.repository.json.useCase.GetGameInfoListUseCase
import com.example.testproject.domain.repository.json.useCase.GetGameInfoUseCase
import com.example.testproject.domain.repository.json.useCase.LoadDataUseCase
import java.lang.RuntimeException
import javax.inject.Inject

class JsonViewModelFactory @Inject constructor(
    private val getGameInfoListUseCase: GetGameInfoListUseCase,
    private val getGameInfoUseCase: GetGameInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase
    ): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(JsonViewModel::class.java)) {
            return JsonViewModel(getGameInfoListUseCase, getGameInfoUseCase, loadDataUseCase) as T
        } else {
            throw RuntimeException("Wrong view model class $modelClass")
        }
    }
}