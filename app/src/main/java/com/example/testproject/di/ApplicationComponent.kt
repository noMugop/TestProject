package com.example.testproject.di

import android.app.Application
import com.example.testproject.data.database.GameInfoDatabase
import com.example.testproject.presentation.view.JsonFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@ApplicationScope
@Component(modules = [DataModule::class, DomainModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun injectJsonFragment(jsonFragment: JsonFragment)

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}