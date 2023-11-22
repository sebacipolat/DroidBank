package com.cipolat.droidbank.domain.cards.usecase

import com.cipolat.droidbank.data.cards.model.Card
import com.cipolat.droidbank.data.cards.repositories.CardsRepository
import com.cipolat.droidbank.network.Resource

class GetCardsUseCase(private val repository: CardsRepository) {
    suspend operator fun invoke(): Resource<ArrayList<Card>> {
        return repository.getUserCards()
    }
}