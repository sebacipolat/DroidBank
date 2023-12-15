package com.cipolat.droidbank.data.cards.local.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cipolat.droidbank.data.cards.local.entities.LocalUserCards
import com.cipolat.droidbank.data.database.AppDataBase
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class UsersCardsDaoTest {

    private lateinit var cardsDao: UsersCardsDao
    private lateinit var db: AppDataBase


    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDataBase::class.java
        ).build()
        cardsDao = db.userCardsDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Config(manifest = Config.NONE)
    fun `when savecard and getcards you should get the added card`() = runBlocking {
        val userCard = LocalUserCards(
            number = "1111 1111 1111 1111",
            name = "patrick Stewart",
            expirationDate = "10/10/2035",
            lastUpdate = "44545477",
            cvv = "XXXX",
            type = "VISA",
            backgroundColor = ""
        )
        cardsDao.saveCard(userCard)
        println(cardsDao.getCards().toString())
        assertTrue(cardsDao.getCards().size == 1)
    }

}