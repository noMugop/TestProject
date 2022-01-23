package com.example.testproject.di

import com.example.testproject.data.repositoryImpl.JsonRepositoryImpl
import com.example.testproject.domain.JsonRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindRepository(impl: JsonRepositoryImpl): JsonRepository
}