package com.example.testproject.presentation.viewModel.json

import android.app.Application
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.di.ApplicationScope
import com.example.testproject.domain.repository.json.useCase.GetGameInfoListUseCase
import com.example.testproject.domain.repository.json.useCase.GetGameInfoUseCase
import com.example.testproject.domain.repository.json.useCase.LoadDataUseCase
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

@ApplicationScope
class JsonViewModelFactory @Inject constructor(
    private val viewModelProvider: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return viewModelProvider[modelClass]?.get() as T
    }
}