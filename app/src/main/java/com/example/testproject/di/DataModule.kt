package com.example.testproject.di

import android.app.Application
import com.example.testproject.data.database.GameInfoDao
import com.example.testproject.data.database.GameInfoDatabase
import com.example.testproject.data.datasource.RemoteDataSource
import com.example.testproject.data.datasource.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource

    companion object {

        @Provides
        fun getGameInfoDb(application: Application): GameInfoDao {
            return GameInfoDatabase.getInstance(application).gameInfoDao()
        }
    }
}