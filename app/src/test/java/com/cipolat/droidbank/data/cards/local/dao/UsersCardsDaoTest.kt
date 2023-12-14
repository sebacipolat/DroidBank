package com.cipolat.droidbank.data.cards.local.dao

import com.cipolat.droidbank.data.cards.local.entities.LocalUserCards
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4


@RunWith(AndroidJUnit4::class)
class UsersCardsDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var roomTestRule = RoomDatabaseTestRule.inMemoryDatabaseBuilder(AppDatabase::class.java)
        .allowMainThreadQueries()
        .build()

    private lateinit var usersCardsDao: UsersCardsDao

    @Before
    fun setUp() {
        val database = roomTestRule.databaseBuilder.build()
        usersCardsDao = database.usersCardsDao()
    }

    @After
    fun tearDown() {
        roomTestRule.closeDatabase()
    }

    @Test
    fun saveCardAndGetCards() = runBlocking {
        val card = LocalUserCards(/* crear objeto LocalUserCards con datos de prueba */)

        // Guardar la tarjeta
        usersCardsDao.saveCard(card)

        // Obtener todas las tarjetas
        val cards = usersCardsDao.getCards()

        // Asegurarse de que la tarjeta guardada está en la lista
        assertTrue(cards.contains(card))
    }

    @Test
    fun getCardSince() = runBlocking {
        // Lógica similar a saveCardAndGetCards, pero para getCardSince
    }

    @Test
    fun cleanCards() = runBlocking {
        // Lógica similar a saveCardAndGetCards, pero para cleanCards
    }
}