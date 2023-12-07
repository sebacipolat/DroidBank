package com.cipolat.droidbank.data.home.local.entity

import androidx.room.Embedded
import androidx.room.Relation
import com.cipolat.droidbank.data.home.model.HomeBody
import com.cipolat.droidbank.data.home.remote.model.Balance
import com.cipolat.droidbank.data.home.remote.model.User
import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem

data class HomeResponseEntity(
    @Embedded
    val user: UserEntity,
    @Relation(parentColumn = "id", entityColumn = "id")
    val balance: BalanceEntity,
    @Relation(parentColumn = "id", entityColumn = "id")
    val transactions: List<TransactionEntity>
)

fun HomeResponseEntity.asHomeBody(): HomeBody {
    val balance = Balance(this.balance.mount)
    val user = User(name = this.user.name, avatarUrl = this.user.avatarUrl)
    val transactions = ArrayList<TransactionItem>()
    this.transactions.forEach {
        transactions.add(TransactionItem(it.name, it.type, it.value, it.iconUrl))
    }
    return HomeBody(user = user, balance = balance, transactions = transactions)
}
