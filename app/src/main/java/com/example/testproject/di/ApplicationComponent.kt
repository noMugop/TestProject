package com.example.testproject.di

import android.app.Application
import android.content.Context
import com.example.testproject.data.database.json.GameInfoDatabase
import com.example.testproject.presentation.view.json.JsonFragment
import com.example.testproject.presentation.view.json.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, DomainModule::class])
interface ApplicationComponent {

    fun inject(jsonFragment: JsonFragment)

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance application: Application,
            @BindsInstance gameInfoDatabase: GameInfoDatabase
        ): ApplicationComponent
    }
}