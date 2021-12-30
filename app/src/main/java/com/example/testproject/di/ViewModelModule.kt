package com.example.testproject.di

import androidx.lifecycle.ViewModel
import com.example.testproject.presentation.viewModel.json.JsonViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(JsonViewModel::class)
    @Binds
    fun bindJsonViewModel(impl: JsonViewModel): ViewModel
}