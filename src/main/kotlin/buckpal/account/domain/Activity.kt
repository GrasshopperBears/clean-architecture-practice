package buckpal.account.domain

import java.time.LocalDateTime

class Activity(private val ownerAccountId: Account.Companion.AccountId,
               private val sourceAccountId: Account.Companion.AccountId,
               private val targetAccountId: Account.Companion.AccountId,
               private val timestamp: LocalDateTime,
               private val money: Money) {
    val activityId: ActivityId? = null

    companion object {
        class ActivityId(private val value: Long) {}
    }

    fun getSourceAccountId(): Account.Companion.AccountId {
        return this.sourceAccountId
    }

    fun getTargetAccountId(): Account.Companion.AccountId {
        return this.targetAccountId
    }

    fun getMoney(): Money {
        return this.money
    }
}