package com.cipolat.droidbank.data.di

import com.cipolat.droidbank.data.cards.repositories.CardsRepository
import com.cipolat.droidbank.data.cards.repositories.CardsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CardsRepositoryModule {
    @Binds
    abstract fun bindCardsRepository(
        cardsRepository: CardsRepositoryImpl
    ): CardsRepository
}
