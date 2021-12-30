package com.example.testproject

import android.app.Application
import com.example.testproject.di.ApplicationComponent
import com.example.testproject.di.DaggerApplicationComponent
import dagger.Component

class MyApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}