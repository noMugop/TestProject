package com.example.testproject.di

import com.example.testproject.presentation.view.json.JsonFragment
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
interface JsonFragmentComponent {

    fun inject(jsonFragment: JsonFragment)

    @Subcomponent.Factory
    interface Factory {

        fun create(): JsonFragmentComponent
    }
}