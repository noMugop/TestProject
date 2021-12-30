package com.example.testproject.di

import android.app.Application
import android.content.Context
import com.example.testproject.data.database.json.GameInfoDao
import com.example.testproject.data.database.json.GameInfoDatabase
import com.example.testproject.data.datasource.LocalDataSource
import com.example.testproject.data.datasource.LocalDataSourceImpl
import com.example.testproject.data.datasource.RemoteDataSource
import com.example.testproject.data.datasource.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

    @ApplicationScope
    @Binds
    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource
}