package com.example.testproject.di

import android.app.Application
import com.example.testproject.data.database.json.MoviesDatabase
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, DomainModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun jsonFragmentComponentFactory(): JsonFragmentComponent.Factory

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance application: Application,
            @BindsInstance moviesDatabase: MoviesDatabase
        ): ApplicationComponent
    }
}