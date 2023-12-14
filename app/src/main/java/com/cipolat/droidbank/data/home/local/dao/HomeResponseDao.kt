package com.cipolat.droidbank.data.home.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.cipolat.droidbank.data.home.local.entity.BalanceEntity
import com.cipolat.droidbank.data.home.local.entity.HomeResponseEntity
import com.cipolat.droidbank.data.home.local.entity.TransactionEntity
import com.cipolat.droidbank.data.home.local.entity.UserEntity

@Dao
interface HomeResponseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBalance(balance: BalanceEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransactions(transactions: List<TransactionEntity>)

    @Query("SELECT * FROM transaction_table")
    suspend fun getTransactions(): List<TransactionEntity>

    @Query("DELETE FROM user_table")
    suspend fun cleanUserData()

    @Transaction
    @Query("SELECT * FROM user_table")
    suspend fun getHomeResponse(): HomeResponseEntity
}
