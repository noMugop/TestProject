package com.example.testproject.di

import com.example.testproject.data.datasource.LocalDataSource
import com.example.testproject.data.datasource.LocalDataSourceImpl
import com.example.testproject.data.datasource.RemoteDataSource
import com.example.testproject.data.datasource.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataModule {



    @ApplicationScope
    @Binds
    fun bindLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

    @ApplicationScope
    @Binds
    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource
}