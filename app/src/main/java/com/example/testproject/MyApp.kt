package com.example.testproject

import android.app.Application
import com.example.testproject.data.database.GameInfoDatabase
import com.example.testproject.di.DaggerApplicationComponent

class MyApp: Application() {

    //1. Переделать проект на Koin
    //2. Начать изучать Jetpack Compose
    //3. Добавить sleep() и загрузку в loadData()
    //4. Добавить popup menu для копироввния текста при долгом зажатии названия игры

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this, GameInfoDatabase.getInstance(this))
    }
}