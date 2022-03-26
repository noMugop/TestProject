package com.example.testproject

import android.app.Application
import com.example.testproject.data.database.json.MoviesDatabase
import com.example.testproject.di.DaggerApplicationComponent

class MyApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this, MoviesDatabase.getInstance(this))
    }
}