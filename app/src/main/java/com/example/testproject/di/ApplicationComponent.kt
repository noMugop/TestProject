package com.example.testproject.di

import android.app.Application
import com.example.testproject.data.database.GameInfoDatabase
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