package buckpal.account.domain

class Money(private val amount: Long) {
    companion object {
        fun add(amount1: Money, amount2: Money): Money {
            return Money(amount1.amount + amount2.amount)
        }
    }

    fun isPositive(): Boolean {
        return this.amount > 0
    }

    fun plus(money: Money): Money {
        return Money(this.amount + money.amount)
    }

    fun negate(): Money {
        return Money(-this.amount)
    }
}