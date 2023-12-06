package com.cipolat.droidbank.data.home.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class HomeResponseEntity(
    @Embedded
    val user: UserEntity,

    @Relation(parentColumn = "id", entityColumn = "id")
    val balance: BalanceEntity,

    @Relation(parentColumn = "id", entityColumn = "id")
    val transactions: List<TransactionEntity>
)