package com.cipolat.droidbank.data.di

import com.cipolat.droidbank.data.home.repositories.HomeRepository
import com.cipolat.droidbank.data.home.repositories.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeRepositoryModule {
    @Binds
    abstract fun bindHomeRepository(
        homeRepository: HomeRepositoryImpl
    ): HomeRepository
}
