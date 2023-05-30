package buckpal.account.domain

import java.time.LocalDateTime

class Account(private val id: AccountId, private val baselineBalance: Money,
              private val activityWindow: ActivityWindow) {
    companion object {
        class AccountId(val id: Long) {
            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as AccountId

                return id == other.id
            }

            override fun hashCode(): Int {
                return id.hashCode()
            }
        }
    }

    fun calculateBalance(): Money {
        return Money.add(this.baselineBalance, this.activityWindow.calculateBalance(this.id))
    }

    fun deposit(money: Money, sourceAccountId: AccountId): Boolean {
        val deposit = Activity(
            this.id,
            sourceAccountId,
            this.id,
            LocalDateTime.now(),
            money)
        this.activityWindow.addActivity(deposit)
        return true
    }

    private fun isWithdrawPossible(money: Money): Boolean {
        return Money.add(calculateBalance(), money.negate())
                    .isPositive()
    }

    fun withdraw(money: Money, targetAccountId: AccountId): Boolean {
        if (!isWithdrawPossible(money)) {
            return false
        }

        val withdrawal = Activity(
            this.id,
            this.id,
            targetAccountId,
            LocalDateTime.now(),
            money)
        this.activityWindow.addActivity(withdrawal)
        return true
    }
}