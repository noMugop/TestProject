package com.example.testproject.presentation.viewModel.json

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.RuntimeException

class JsonViewModelFactory(private val application: Application): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(JsonViewModel::class.java)) {
            return JsonViewModel(application) as T
        } else {
            throw RuntimeException("Wrong view model class $modelClass")
        }
    }
}