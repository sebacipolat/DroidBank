package com.cipolat.droidbank.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cipolat.droidbank.data.cards.local.dao.UsersCardsDao
import com.cipolat.droidbank.data.cards.local.entities.LocalUserCards
import com.cipolat.droidbank.data.home.local.dao.HomeResponseDao
import com.cipolat.droidbank.data.home.local.entity.BalanceEntity
import com.cipolat.droidbank.data.home.local.entity.TransactionEntity
import com.cipolat.droidbank.data.home.local.entity.UserEntity

@Database(
    entities = [LocalUserCards::class, UserEntity::class, BalanceEntity::class, TransactionEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userCardsDao(): UsersCardsDao
    abstract fun userDataDao(): HomeResponseDao

}
