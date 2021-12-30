package com.example.testproject.di

import android.app.Application
import android.content.Context
import com.example.testproject.presentation.view.json.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, DomainModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}