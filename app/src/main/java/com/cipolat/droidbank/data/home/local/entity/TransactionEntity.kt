package com.cipolat.droidbank.data.home.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem

@Entity(tableName = "transaction_table")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val type: String,
    val value: String,
    @ColumnInfo(name = "icon_url")
    val iconUrl: String
)

fun TransactionItem.asEntity(): TransactionEntity {
    return TransactionEntity(
        name = this.name,
        type = this.type,
        value = this.value,
        iconUrl = this.iconUrl
    )
}

fun List<TransactionItem>.asEntityList(): List<TransactionEntity> {
    val list = ArrayList<TransactionEntity>()
    this.forEach {
        list.add(it.asEntity())
    }
    return list
}
