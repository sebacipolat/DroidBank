package com.cipolat.droidbank.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cipolat.droidbank.data.cards.local.dao.UsersCardsDao
import com.cipolat.droidbank.data.cards.local.entities.LocalUserCards

@Database(entities = [LocalUserCards::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userCardsDao(): UsersCardsDao
}
