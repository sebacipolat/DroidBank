package com.cipolat.droidbank.domain.cards.usecase

import com.cipolat.droidbank.data.cards.model.Card
import com.cipolat.droidbank.data.cards.repositories.CardsRepository
import com.cipolat.droidbank.data.network.Resource
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val repository: CardsRepository) {
    suspend operator fun invoke(): Resource<List<Card>> {
        return repository.getUserCards(15)
    }
}
