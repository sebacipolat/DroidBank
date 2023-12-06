package com.cipolat.droidbank.data.home.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "balance_table")
data class BalanceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val mount: String
)