package com.example.testproject.di

import android.app.Application
import android.content.Context
import com.example.testproject.data.database.json.GameInfoDatabase
import com.example.testproject.presentation.view.json.JsonFragment
import com.example.testproject.presentation.view.json.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@ApplicationScope
@Component(modules = [DataModule::class, DomainModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun jsonFragmentComponentFactory(): JsonFragmentComponent.Factory

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance @Named("application") application: Application,
            @BindsInstance @Named("gameInfoDatabase") gameInfoDatabase: GameInfoDatabase
        ): ApplicationComponent
    }
}